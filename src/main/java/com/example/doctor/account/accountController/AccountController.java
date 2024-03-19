package com.example.doctor.account.accountController;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountApplication.AccountApplication;
import com.example.doctor.account.accountRepository.IAccountRepository;
import com.example.doctor.account.accountService.AccountService;
import com.example.doctor.command.MessageRespone;
import com.example.doctor.command.commandRegister;
import com.example.doctor.doctor.doctorApplication.DoctorsApplication;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientApplication.PatientApplication;
import com.example.doctor.patient.patientService.PatientService;
import com.example.doctor.role.roleRepository.IRoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authentications")
public class AccountController {
    @Autowired
    public AccountApplication accountApplication;
    @Autowired
    public PatientApplication patientApplication;
    @Autowired
    public IAccountRepository accountRepository;
    @Autowired
    public DoctorsApplication doctorApplication;
    @Autowired
    public IRoleRepository roleRepository;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody commandRegister commandRegister) {
        try {
            Patient users = Patient.builder()
                    .fullname(commandRegister.getFullname())
                    .email(commandRegister.getEmail())
                    .phoneNumber(commandRegister.getPhoneNumber())
                    .dateOfbirth(commandRegister.getDateOfbirth())
                    .gender(commandRegister.getGender())
                    .build();
            Patient createdUser;
            createdUser = patientApplication.createPatient(users);
            String role = "patient";
            Account account = Account.builder()
                    .loginName(commandRegister.getLoginName())
                    .password(commandRegister.getPassword())
                    .userId(createdUser.get_id())
                    .roles(commandRegister.setRoles(role))
                    .build();
            accountApplication.createAccount(account);
            }catch(Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new MessageRespone("User registered successfully!"));
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> SignInUser(@Valid @RequestBody commandRegister commandRegister) {
        try {
            String userName = commandRegister.getLoginName();
            String passWord = commandRegister.getPassword();
            if(accountApplication.authentication(userName, passWord)){
                if(Objects.equals(accountRepository.findRoleByLoginName(userName), "patient")){
                    return ResponseEntity.ok(new MessageRespone("Welcome to patient page!"));
                } else if (Objects.equals(accountRepository.findRoleByLoginName(userName), "doctor")) {
                    return ResponseEntity.ok(new MessageRespone("Welcome to doctor page!"));
                } else if (Objects.equals(accountRepository.findRoleByLoginName(userName), "admin")) {
                    return ResponseEntity.ok(new MessageRespone("Welcome to admin page!"));
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new MessageRespone("User registered successfully!"));
    }

}
