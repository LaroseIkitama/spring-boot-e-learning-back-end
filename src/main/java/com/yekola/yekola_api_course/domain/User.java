package com.yekola.yekola_api_course.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;

    private String email;

    private String password;
    private String biography;
    private String website;
    private String role;
    private Boolean enabled;
}
