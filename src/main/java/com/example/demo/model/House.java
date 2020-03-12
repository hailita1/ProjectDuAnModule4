package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

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

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;

    }

    public Long getIdNha() {
        return idNha;
    }

    public void setIdNha(Long idNha) {
        this.idNha = idNha;
    }


    public String getTenNha() {
        return tenNha;
    }

    public void setTenNha(String tenNha) {
        this.tenNha = tenNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoLuongPhongNgu() {
        return soLuongPhongNgu;
    }

    public void setSoLuongPhongNgu(String soLuongPhongNgu) {
        this.soLuongPhongNgu = soLuongPhongNgu;
    }

    public String getSoLuongPhongTam() {
        return soLuongPhongTam;
    }

    public void setSoLuongPhongTam(String soLuongPhongTam) {
        this.soLuongPhongTam = soLuongPhongTam;
    }

    public String getMoTaChung() {
        return moTaChung;
    }

    public void setMoTaChung(String moTaChung) {
        this.moTaChung = moTaChung;
    }

    public double getGiaTienTheoDem() {
        return giaTienTheoDem;
    }

    public void setGiaTienTheoDem(double giaTienTheoDem) {
        this.giaTienTheoDem = giaTienTheoDem;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public CategoryHouse getCategoryHouse() {
        return categoryHouse;
    }

    public void setCategoryHouse(CategoryHouse categoryHouse) {
        this.categoryHouse = categoryHouse;
    }

    public CategoryRoom getCategoryRoom() {
        return categoryRoom;
    }

    public void setCategoryRoom(CategoryRoom categoryRoom) {
        this.categoryRoom = categoryRoom;
    }
}
