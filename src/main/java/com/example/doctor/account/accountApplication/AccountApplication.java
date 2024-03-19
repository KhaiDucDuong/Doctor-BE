package com.example.doctor.account.accountApplication;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountService.AccountService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication {
    @Autowired
    private AccountService accountService;
    public Account createAccount(Account account) throws Exception {
        //validate data
        if (StringUtils.isEmpty(account.getLoginName())) {
            throw new Exception("Username can not be empty");
        }
        else if (StringUtils.isEmpty(account.getPassword())) {
            throw new Exception("Password can not be empty");
        }
        else if (accountService.getAccountByAccountName(account.getLoginName())!=null)
        {
            throw new Exception("Account name has been created");
        }
        return accountService.addAccount(account);
    }
}
