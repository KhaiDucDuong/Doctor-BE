package com.example.doctor.account.accountService;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountRepository.IAccountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {
    @Autowired
    private IAccountRepository repository;

    public AccountService(IAccountRepository repository) {
        this.repository = repository;
    }

    public Account addAccount(Account account) {
        return repository.save(account);

    }

    public List<Account> getAccountByUserID(ObjectId userId) {
        return repository.findByAndUserId(userId);
    }

    public String findRolesByLoginName(String loginName) {
        Account account = repository.findByLoginName(loginName);
        if (account != null) {
            return account.getRoles();
        } else {
            return null;
        }
    }

    public String findUsername(String loginName) {
        Account account = repository.findByLoginName(loginName);
        if (account != null) {
            return account.getLoginName();
        } else {
            return null;
        }
    }
    public String findPassword(String loginName) {
        Account account = repository.findByLoginName(loginName);
        if (account != null) {
            return account.getPassword();
        } else {
            return null;
        }
    }
    public ObjectId findUserId(String loginName) {
        Account account = repository.findByLoginName(loginName);
        if (account != null) {
            return account.getUserId();
        } else {
            return null;
        }
    }

}
