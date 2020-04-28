package com.example.demo.service;

import com.example.demo.model.Host;
import com.example.demo.model.House;

public interface HouseService {
    Iterable<House> findAll();

    House findById(Long id);

    void save(House house);

    void remove(Long id);

    Iterable<House> findAllByTrangThai(String trangThai);

    Iterable<House> findAllByHost(Host host);

    Iterable<House> findAllByDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTamOrGiaTienTheoDemBetween(String diaChi, int slpn, int slpt, Double dauDuoi, Double dauTren);

    Iterable<House> findAllBySoLuongPhongNguOrDiaChiContainsOrSoLuongPhongTamOrGiaTienTheoDemBetween(int slpn, String diaChi, int slpt, Double dauDuoi, Double dauTren);

    Iterable<House> findAllBySoLuongPhongTamOrDiaChiContainsOrSoLuongPhongNguOrGiaTienTheoDemBetween(int slpt, String diaChi, int slpn, Double dauDuoi, Double dauTren);

    Iterable<House> findAllByGiaTienTheoDemBetweenOrDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTam(Double dauDuoi, Double dauTren, String diaChi, int slpn, int slpt);
}
