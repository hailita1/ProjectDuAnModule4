package com.example.demo.repository;

import com.example.demo.model.Host;
import com.example.demo.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    Iterable<House> findAllByTrangThai(String trangThai);

    Iterable<House> findAllByHost(Host host);

    //Tìm kiếm 1 tiêu chí
    Iterable<House> findAllByDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTamOrGiaTienTheoDemBetween(String diaChi, int slpn, int slpt, Double dauDuoi, Double dauTren);

    Iterable<House> findAllBySoLuongPhongNguOrDiaChiContainsOrSoLuongPhongTamOrGiaTienTheoDemBetween(int slpn, String diaChi, int slpt, Double dauDuoi, Double dauTren);

    Iterable<House> findAllBySoLuongPhongTamOrDiaChiContainsOrSoLuongPhongNguOrGiaTienTheoDemBetween(int slpt, String diaChi, int slpn, Double dauDuoi, Double dauTren);

    Iterable<House> findAllByGiaTienTheoDemBetweenOrDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTam(Double dauDuoi, Double dauTren, String diaChi, int slpn, int slpt);

    //Tìm kiếm theo 2 tiêu chí
    Iterable<House> findAllByDiaChiContainsAndSoLuongPhongTamOrSoLuongPhongNguOrGiaTienTheoDemBetween(String diaChi, int slpt, int slpn, Double dauDuoi, Double dauTren);
}
