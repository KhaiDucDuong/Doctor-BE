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
import com.example.doctor.role.roleRepository.IRoleRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/authentications")
@CrossOrigin(
        origins = {"http://localhost:3000", "http://127.0.0.1:3000/"},
        allowCredentials = "true",
        allowedHeaders = "*"
)
public class AccountController {
    @Autowired
    public AccountApplication accountApplication;
    @Autowired
    public PatientApplication patientApplication;
    @Autowired
    public IAccountRepository accountRepository;
    @Autowired
    public AccountService accountService;
    @Autowired
    private HttpServletRequest request;
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
        ObjectId userId = null;
        HttpSession session;
        try {
            String userName = commandRegister.getLoginName();
            String passWord = commandRegister.getPassword();
            if (accountApplication.authentication(userName, passWord)) {
                if (Objects.equals(accountService.findRolesByLoginName(userName), "patient")) {
                    userId = accountService.findUserId(userName);
                } else if (Objects.equals(accountService.findRolesByLoginName(userName), "doctor")) {
                    userId = accountService.findUserId(userName);
                } else if (Objects.equals(accountService.findRolesByLoginName(userName), "admin")) {
                    userId = accountService.findUserId(userName);
                }
            }
            else
            {
                return new ResponseEntity<>(
                    "Authentication failed",
                    HttpStatus.BAD_REQUEST);
            }
            session = request.getSession();
            session.setAttribute("userId", userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok (userId);
    }

}
