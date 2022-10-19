package com.assignment.xeno.assignment_xeno.Repository;

import com.assignment.xeno.assignment_xeno.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactReporsitory extends JpaRepository<Contact, Long> {
}
