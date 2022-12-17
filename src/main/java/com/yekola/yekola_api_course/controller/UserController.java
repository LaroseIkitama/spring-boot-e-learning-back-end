package com.yekola.yekola_api_course.controller;


import com.yekola.yekola_api_course.domain.User;
import com.yekola.yekola_api_course.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    UserService userService;


    @PostMapping("create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/get")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }



}
