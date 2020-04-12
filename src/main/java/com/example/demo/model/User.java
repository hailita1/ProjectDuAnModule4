package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    private String hoTen;

    private String diaChi;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

}
