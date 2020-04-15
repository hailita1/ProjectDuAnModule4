package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

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
    private Integer danhGia;

    @Column
    private String trangThai;

    @Column
    private Double thanhTien;
    @Column
    private String phanHoi;

    @ManyToOne
    @MapsId("idNha")
    private House house;

    @ManyToOne
    @MapsId("idCustomer")
    private Customer customer;
}