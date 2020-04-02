package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNha;

    private String tenNha;

    private String diaChi;

    private int soLuongPhongNgu;

    private int soLuongPhongTam;

    private String moTaChung;

    private double giaTienTheoDem;

    private String trangThai;

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @ManyToOne
    @JoinColumn(name = "loaiNha_id")
    private CategoryHouse categoryHouse;

    @ManyToOne
    @JoinColumn(name = "loaiPhong_id")
    private CategoryRoom categoryRoom;

    @ManyToOne
    @JoinColumn(name = "chunha_id")
    private Host host;


    @OneToMany(targetEntity = Image.class, mappedBy = "house", cascade = CascadeType.REMOVE)
    private List<Image> picture;

    @OneToMany(mappedBy = "customer")
    private List<Deal> deals;
}
