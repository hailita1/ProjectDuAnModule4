package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String ho;

    @Column
    private String ten;

    @Column
    private int cmnd;

    @Column
    private String diaChi;

    @Column
    private int sdt;
    @JsonBackReference
    @OneToMany(mappedBy = "house")
    private List<Deal> deals;

}
