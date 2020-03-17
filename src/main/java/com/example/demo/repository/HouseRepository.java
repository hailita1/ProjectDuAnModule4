package com.example.demo.repository;

import com.example.demo.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {

    Iterable<House> findAllBySoLuongPhongNguContains(String soLuongPhongNgu);

    Iterable<House> findAllBySoLuongPhongTamContains(String soLuongPhongTam);

    Iterable<House> findAllByDiaChiContains(String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsAndSoLuongPhongTamContains(String soLuongPhongNgu, String soLuongPhongTam);

    Iterable<House> findAllBySoLuongPhongNguContainsAndDiaChiContains(String soLuongPhongNgu, String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsAndDiaChiContainsAndSoLuongPhongTamContains(String soLuongPhongNgu, String diaChi, String soLuongPhongTam);

    Iterable<House> findAllByGiaTienTheoDemBetween(Double dauDuoi, Double dauTren);

    Iterable<House> findAllByTrangThai(String trangThai);
}
