package com.example.doctor.account.accountRepository;

import com.example.doctor.account.Account;
import com.example.doctor.department.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IAccountRepository extends MongoRepository<Account,String> {
    List<Account> findByLoginName(String loginName);
}
