package com.example.doctor.account.accountController;

import com.example.doctor.account.Account;
import com.example.doctor.account.accountApplication.AccountApplication;
import com.example.doctor.account.accountService.AccountService;
import com.example.doctor.command.MessageRespone;
import com.example.doctor.command.commandRegister;
import com.example.doctor.doctor.doctorApplication.DoctorsApplication;
import com.example.doctor.patient.Patient;
import com.example.doctor.patient.patientApplication.PatientApplication;
import com.example.doctor.patient.patientService.PatientService;
import com.example.doctor.role.Role;
import com.example.doctor.role.Roles;
import com.example.doctor.role.roleRepository.IRoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/authentications")
public class AccountController {
    @Autowired
    public AccountApplication accountApplication;
    @Autowired
    public PatientApplication patientApplication;
    @Autowired
    public AccountService accountService;
    @Autowired
    public PatientService patientService;
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
            createdUser = patientService.addPateint(users);
            Set<Roles> strRoles = commandRegister.getRoles();
            Set<Roles> roles = new HashSet<>();

            if (strRoles == null) {
                Roles userRole = roleRepository.findByRoleName(Role.ROLE_PATEINT)
                        .orElseThrow(() -> new RuntimeException("Error"));
                roles.add(userRole);
            }
            Account account = Account.builder()
                    .loginName(commandRegister.getLoginName())
                    .password(commandRegister.getPassword())
                    .userId(createdUser.get_id())
                    .build();
            accountService.addAccount(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new MessageRespone("User registered successfully!"));
    }
}
