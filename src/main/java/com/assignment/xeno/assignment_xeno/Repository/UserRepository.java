package com.assignment.xeno.assignment_xeno.Repository;

import com.assignment.xeno.assignment_xeno.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findUserByUsername(String username);
}
