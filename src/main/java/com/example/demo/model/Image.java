package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnh;
    private String tenAnh;

    public Image() {
    }

    public Long getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(Long idAnh) {
        this.idAnh = idAnh;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_nha")
    private House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

}
