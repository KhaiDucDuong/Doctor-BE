package com.example.doctor.account.accountService;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountRepository.IAccountRepository;
import com.example.doctor.department.Department;
import com.example.doctor.department.deparmentRepository.IdeparmentRepository;
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
    public Account addAccount(Account account){
        return repository.save(account);
    }
    public List<Account> getAccountByAccountName(String loginName){
        return repository.findByLoginName(loginName);
    }
    public List<Account> getAccountByUserID(ObjectId userId){
        return repository.findByAndUserId(userId);
    }
}
