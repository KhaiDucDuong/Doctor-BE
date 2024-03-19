package com.example.doctor.account.accountApplication;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountService.AccountService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class AccountApplication {
    @Autowired
    private AccountService accountService;
    @Autowired
    private HttpServletRequest request;
    public Account createAccount(Account account) throws Exception {
        //validate data
        if (StringUtils.isEmpty(account.getLoginName())) {
            throw new Exception("Username can not be empty");
        }
        else if (StringUtils.isEmpty(account.getPassword())) {
            throw new Exception("Password can not be empty");
        }
        else if (accountService.findUsername(account.getLoginName())==null)
        {
            throw new Exception("Account name has been created");
        }
        return accountService.addAccount(account);
    }
    public boolean authentication(String userName, String password){
        if(accountService.findUsername(userName)!=null)
        {
            if(Objects.equals(accountService.findPassword(userName), password))
            {
                return true;
            }
        }
        return false;
    }
    public ObjectId nextAuthen(String userName, String password){
        ObjectId userId = null;
        if (authentication(userName, password)){
            if(Objects.equals(accountService.findRolesByLoginName(userName), "patient")){
                userId = accountService.findUserId(userName);
            } else if (Objects.equals(accountService.findRolesByLoginName(userName), "doctor")) {
                userId = accountService.findUserId(userName);
            } else if (Objects.equals(accountService.findRolesByLoginName(userName), "admin")) {
                userId = accountService.findUserId(userName);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);
        return (ObjectId) session.getAttribute(String.valueOf(userId));
    }
}
