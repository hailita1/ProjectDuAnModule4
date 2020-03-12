package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNha;

    private Long idChuNha;

    private String tenNha;

    private String loaiNha;

    private String loaiPhong;

    private String diaChi;

    private int soLuongPhongNgu;

    private int soLuongPhongTam;

    private String moTaChung;

    private double giaTienTheoDem;

    private String trangThai;
}
