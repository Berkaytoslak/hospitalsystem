package com.hospitalsystem.hospitalsystem.util.security;

import com.hospitalsystem.hospitalsystem.database.entity.RoleEntity;
import com.hospitalsystem.hospitalsystem.database.entity.UserEntity;
import com.hospitalsystem.hospitalsystem.database.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityService implements UserDetailsService {


    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not findUser with email =" + email);
        }

        UserEntity userEntity = user.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        // Kullanıcının rollerine göre ilgili rolleri ekleyin
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.isEnable(),
                true,
                true,
                true,
                authorities);
    }

}
