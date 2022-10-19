package com.assignment.xeno.assignment_xeno.Service;

import com.assignment.xeno.assignment_xeno.Model.Contact;
import com.assignment.xeno.assignment_xeno.Repository.ContactReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactReporsitory contactReporsitory;

    public void addQuery(Contact contact){
        contactReporsitory.save(contact);
    }

    public List<Contact> getAllQueries(){
        return contactReporsitory.findAll();
    }

}
