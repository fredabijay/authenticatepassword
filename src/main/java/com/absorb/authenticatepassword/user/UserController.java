package com.absorb.authenticatepassword.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<String> display() {
        return new ResponseEntity<String>("test", HttpStatus.OK);
    }

    @PostMapping(
        value = "/user/create",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User u = userService.createUser(user);
        if (u == null) {
           return new ResponseEntity<User>(u, HttpStatus.CONFLICT);
        } else {
           return new ResponseEntity<User>(u, HttpStatus.CREATED);
        }
    }

    @PostMapping(
        value = "/user/authenticate",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean authenticate(@RequestBody User user) {
        return userService.authenticate(user);
    }
}