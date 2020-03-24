package com.example.demo.service;

import com.example.demo.model.Host;
import com.example.demo.model.House;

public interface HouseService {
    Iterable<House> findAll();

    House findById(Long id);

    void save(House house);

    void remove(Long id);

    Iterable<House> findAllBySoLuongPhongNguLessThanEqualAndTrangThai(int soLuongPhongNgu, String trangThai);

    Iterable<House> findAllBySoLuongPhongTamLessThanEqualAndTrangThai(int soLuongPhongTam, String trangThai);

    Iterable<House> findAllByDiaChiContainsAndTrangThai(String diaChi, String trangThai);

    Iterable<House> findAllByGiaTienTheoDemBetweenAndTrangThai(Double dauDuoi, Double dauTren, String trangThai);

    Iterable<House> findAllByTrangThai(String trangThai);

    Iterable<House> findAllByHost(Host host);
}
