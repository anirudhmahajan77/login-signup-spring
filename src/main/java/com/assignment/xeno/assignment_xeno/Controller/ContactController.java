package com.assignment.xeno.assignment_xeno.Controller;

import com.assignment.xeno.assignment_xeno.Model.Contact;
import com.assignment.xeno.assignment_xeno.Model.RequestModel.NewQuery;
import com.assignment.xeno.assignment_xeno.Service.ContactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@Tag(name = "Contact Controller",
        description = "This is a controller for Queries to Admin")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity addQuery(@RequestBody NewQuery contact){
        contactService.addQuery(Contact.builder().email(contact.getEmail())
                .message(contact.getMessage())
                .subject(contact.getSubject()).build());

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity fetchQueries(){
        List<Contact> result = contactService.getAllQueries();
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
