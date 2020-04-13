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
    private String danhGia;

    @Column
    private String phanHoi;

    @Column
    private String trangThai;

    @Column
    private Double thanhTien;

    @JsonManagedReference
    @ManyToOne
    @MapsId("idNha")
    private House house;

    @JsonManagedReference
    @ManyToOne
    @MapsId("id")
    private User user;
}