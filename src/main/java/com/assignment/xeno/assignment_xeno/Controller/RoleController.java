package com.assignment.xeno.assignment_xeno.Controller;


import com.assignment.xeno.assignment_xeno.Model.RequestModel.NewRole;
import com.assignment.xeno.assignment_xeno.Model.Role;
import com.assignment.xeno.assignment_xeno.Service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@Tag(name = "Role Controller", description = "This is a controller for User Roles and it's CRUD operations")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable("id") Long id) {
        Role result = roleService.getRoleById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllRoles() {
        List<Role> result = roleService.getAllRoles();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addNewRole(@RequestBody NewRole nrole) {
        roleService.addRole(nrole);
        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity addNewRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRoleById(id);
        return new ResponseEntity("Role Deleted!", HttpStatus.OK);
    }

}
