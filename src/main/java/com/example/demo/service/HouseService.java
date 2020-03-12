package com.example.demo.service;

import com.example.demo.model.House;

public interface HouseService {
    Iterable<House> findAll();

    House findById(Long id);

    void save(House house);

    void remove(Long id);

    Iterable<House> findAllBySoLuongPhongNguContains(String soLuongPhongNgu);

    Iterable<House> findAllBySoLuongPhongTamContains(String soLuongPhongTam);

    Iterable<House> findAllByDiaChiContains(String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String soLuongPhongTam);

    Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContains(String soLuongPhongNgu, String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String diaChi, String soLuongPhongTam);
}
