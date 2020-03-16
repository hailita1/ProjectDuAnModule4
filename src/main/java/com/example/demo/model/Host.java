package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idChuNha;
    private String password;
    private String hoTen;
    private String diaChi;
}
