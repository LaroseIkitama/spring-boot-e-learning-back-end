package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    @NotNull(message = "The username must not be null")
    private String username;
    private String firstName;
    private String lastName;
    @NotNull(message = "The email must not be null")
    @Email
    private String email;
    @NotNull(message = "The password must not be null")
    private String password;
    private String biography;
    private String website;
    private String role;
}
