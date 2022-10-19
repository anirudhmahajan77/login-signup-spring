package com.assignment.xeno.assignment_xeno.Model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewQuery {
    String email;
    String subject;
    String message;
}
