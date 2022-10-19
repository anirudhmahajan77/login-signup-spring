package com.assignment.xeno.assignment_xeno.Controller;


import com.assignment.xeno.assignment_xeno.Model.ApplicationUser;
import com.assignment.xeno.assignment_xeno.Model.RequestModel.JwtRequest;
import com.assignment.xeno.assignment_xeno.Model.RequestModel.NewUser;
import com.assignment.xeno.assignment_xeno.Security.JwtUtil;
import com.assignment.xeno.assignment_xeno.Service.CustomUserDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Controller",
        description = "This is a controller for User to Login, Signup and Access Dashboard")
@CrossOrigin("*")
public class UserController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailService customUserDetailService;

    @PostMapping("/login")
    @Operation(summary = "Authorize Existing User",
            description = "Authorize existing user using their Username and password " +
                    "and send a JWT token in response")
    public ResponseEntity loginUser(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtRequest.getUsername(),
                    jwtRequest.getPassword()
            ));
        } catch (UsernameNotFoundException e) {

            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        }
        ApplicationUser user = this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(user);


        return new ResponseEntity("Bearer " + token, HttpStatus.OK);
    }

    @PostMapping("/register")
    @Operation(summary = "Register a New User",
            description = "Add a new User in the database and authenticate them with a JWT token")
    public ResponseEntity registerUser(@RequestBody NewUser user) {
        customUserDetailService.registerUser(user);
        return new ResponseEntity("Done", HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Get All Users", description = "Get the list of all registered users on the system")
    public ResponseEntity getAllUsers() {
        List<ApplicationUser> result = customUserDetailService.getAllUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/data")
    @Operation(summary = "Send Dummy Data to Registered User",
            description = "Send Best Kids Movies to user")
    public ResponseEntity getDummyData() {
        List<String> data = new ArrayList<>();
        data.add("Croods");
        data.add("Luck");
        data.add("Soul");
        data.add("Jungle Book");


        return new ResponseEntity(data, HttpStatus.OK);
    }

}
