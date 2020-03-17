package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNha;

    private String tenNha;

    private String diaChi;

    private String soLuongPhongNgu;

    private String soLuongPhongTam;

    private String moTaChung;

    private double giaTienTheoDem;

    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "loaiNha_id")
    private CategoryHouse categoryHouse;

    @ManyToOne
    @JoinColumn(name = "loaiPhong_id")
    private CategoryRoom categoryRoom;

    @ManyToOne
    @JoinColumn(name = "chunha_id")
    private Host host;


    @OneToMany(targetEntity = Image.class, mappedBy = "house")
    private List<Image> picture;

    @OneToMany(mappedBy = "customer")
    private List<Deal> deals;
}
