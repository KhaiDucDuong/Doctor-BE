package com.example.doctor.role.roleRepository;

import com.example.doctor.role.Role;
import com.example.doctor.role.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IRoleRepository extends MongoRepository<Roles, String> {
    Optional<Roles> findByRoleName(Role role);
}
