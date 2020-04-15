package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGiaoDich;

    @Column
    private Date ngayDen;

    @Column
    private Date ngayDi;

    @Column
    private int danhGia;

    @Column
    private String trangThai;

    @Column
    private Double thanhTien;

    @Column
    private String phanHoi;

    @JsonManagedReference
    @ManyToOne
    @MapsId("idNha")
    private House house;

//    @JsonManagedReference
    @ManyToOne
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "id_customer", updatable = false)
//    @MapsId("idCustomer")
    private Customer customer;
}