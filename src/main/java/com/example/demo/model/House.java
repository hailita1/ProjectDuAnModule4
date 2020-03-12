package com.example.demo.model;

import javax.persistence.*;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNha;

    private Long idChuNha;

    private String tenNha;

    private String diaChi;

    private int soLuongPhongNgu;

    private int soLuongPhongTam;

    private String moTaChung;

    private double giaTienTheoDem;

    private String trangThai;

    public Long getIdNha() {
        return idNha;
    }

    public void setIdNha(Long idNha) {
        this.idNha = idNha;
    }

    public Long getIdChuNha() {
        return idChuNha;
    }

    public void setIdChuNha(Long idChuNha) {
        this.idChuNha = idChuNha;
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

    public int getSoLuongPhongNgu() {
        return soLuongPhongNgu;
    }

    public void setSoLuongPhongNgu(int soLuongPhongNgu) {
        this.soLuongPhongNgu = soLuongPhongNgu;
    }

    public int getSoLuongPhongTam() {
        return soLuongPhongTam;
    }

    public void setSoLuongPhongTam(int soLuongPhongTam) {
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

    @ManyToOne
    @JoinColumn(name = "loaiNha_id")
    private CategoryHouse categoryHouse;

    @ManyToOne
    @JoinColumn(name = "loaiPhong_id")
    private CategoryRoom categoryRoom;
}
