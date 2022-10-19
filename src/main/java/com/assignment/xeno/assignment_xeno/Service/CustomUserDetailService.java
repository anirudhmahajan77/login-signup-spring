package com.assignment.xeno.assignment_xeno.Service;

import com.assignment.xeno.assignment_xeno.Model.ApplicationUser;
import com.assignment.xeno.assignment_xeno.Model.RequestModel.NewUser;
import com.assignment.xeno.assignment_xeno.Model.Role;
import com.assignment.xeno.assignment_xeno.Repository.RoleRepository;
import com.assignment.xeno.assignment_xeno.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findUserByUsername(username);
        return user;
    }

    public void registerUser(NewUser dummy) {
        Set<Long> list = dummy.getAuthorities();
        Set<Role> roles = new HashSet<>();
        roles.addAll(roleRepository.findAllById(list));

        ApplicationUser user = new ApplicationUser(dummy.getUsername(),
                passwordEncoder.encode(dummy.getPassword()),
                roles,
                dummy.getName());
        userRepository.save(user);
    }

    public List<ApplicationUser> getAllUsers() {
        return userRepository.findAll();
    }

}
