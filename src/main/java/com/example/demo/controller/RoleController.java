package com.example.demo.controller;

import com.example.demo.model.CategoryHouse;
import com.example.demo.model.Role;
import com.example.demo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Role>> listAllHouse() {
        Iterable<Role> roles = roleService.findAll();
        if (roles == null) {
            return new ResponseEntity<Iterable<Role>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Role>>(roles, HttpStatus.OK);
    }
}
