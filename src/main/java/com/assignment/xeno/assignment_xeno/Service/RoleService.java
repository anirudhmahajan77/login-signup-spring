package com.assignment.xeno.assignment_xeno.Service;

import com.assignment.xeno.assignment_xeno.Model.RequestModel.NewRole;
import com.assignment.xeno.assignment_xeno.Model.Role;
import com.assignment.xeno.assignment_xeno.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role getRoleById(Long id) {
        Optional<Role> result = roleRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void addRole(NewRole role) {
        Role neRole = Role.builder()
                .name(role.getName())
                .build();
        roleRepository.save(neRole);
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }
}
