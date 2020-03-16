package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Deal {

    @EmbeddedId
    private CustomerHouseId customerHouseId;

    @Column
    private Date ngayDen;

    @Column
    private Date ngayDi;

    @Column
    private String danhGia;

    @Column
    private String trangThai;

    @Column
    private Double thanhTien;

    @JsonIgnore
    @ManyToOne
    @MapsId("idNha")
    private House house;

    @JsonIgnore
    @ManyToOne
    @MapsId("idCustomer")
    private Customer customer;
}