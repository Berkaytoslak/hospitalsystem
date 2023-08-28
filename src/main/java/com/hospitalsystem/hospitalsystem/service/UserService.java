package com.hospitalsystem.hospitalsystem.service;

import com.hospitalsystem.hospitalsystem.database.entity.RoleEntity;
import com.hospitalsystem.hospitalsystem.database.entity.UserEntity;
import com.hospitalsystem.hospitalsystem.database.repository.RoleEntityRepository;
import com.hospitalsystem.hospitalsystem.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userRepository;
    @Autowired
    RoleEntityRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void saveUserByRole(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        Set<RoleEntity> roles1 = user.getRoles();
        for (RoleEntity role : roles1){
            if (role.getName().equals("user")){
                roles.add(roleRepository.findByName("user").get());
            }
            else if (role.getName().equals("admin")){
                roles.add(roleRepository.findByName("admin").get());
            }
            else if (role.getName().equals("doctor")){
                roles.add(roleRepository.findByName("doctor").get());
            }

        }

        user.setRoles(roles);
        userRepository.save(user);
    }


}
