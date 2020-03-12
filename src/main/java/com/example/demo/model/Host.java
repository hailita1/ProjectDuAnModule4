package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idChuNha;
    private String password;
    private String hoTen;
    private String diaChi;

    public Host() {
    }

    public Long getIdChuNha() {
        return idChuNha;
    }

    public void setIdChuNha(Long idChuNha) {
        this.idChuNha = idChuNha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
