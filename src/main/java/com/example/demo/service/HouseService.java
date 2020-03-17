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

    Iterable<House> findAllBySoLuongPhongNguContainsAndSoLuongPhongTamContains(String soLuongPhongNgu, String soLuongPhongTam);

    Iterable<House> findAllBySoLuongPhongNguContainsAndDiaChiContains(String soLuongPhongNgu, String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsAndDiaChiContainsAndSoLuongPhongTamContains(String soLuongPhongNgu, String diaChi, String soLuongPhongTam);

    Iterable<House> findAllByGiaTienTheoDemBetween(Double dauDuoi, Double dauTren);

    Iterable<House> findAllByTrangThai(String trangThai);
}
