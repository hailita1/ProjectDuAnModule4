package com.example.demo.repository;

import com.example.demo.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {

    Iterable<House> findAllBySoLuongPhongNguContains(String soLuongPhongNgu);

    Iterable<House> findAllBySoLuongPhongTamContains(String soLuongPhongTam);

    Iterable<House> findAllByDiaChiContains(String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String soLuongPhongTam);

    Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContains(String soLuongPhongNgu, String diaChi);

    Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String diaChi, String soLuongPhongTam);
}
