package com.yekola.yekola_api_course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;

    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    @Email
    private String email;
    @Column(unique = true,nullable = false)
    private String password;

    private String biography;
    private String website;
    private String role;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CategoryEntity> categories;
}
