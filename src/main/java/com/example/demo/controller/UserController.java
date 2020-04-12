package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> listAllUser() {
        Iterable<User> users = userService.findAll();
        if (users == null) {
            return new ResponseEntity<Iterable<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/houses/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User user1 = userService.findById(id);

        if (user1 == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        user1.setDiaChi(user.getDiaChi());
        user1.setPassword(user.getPassword());
        user1.setHoTen(user.getHoTen());

        userService.save(user1);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
