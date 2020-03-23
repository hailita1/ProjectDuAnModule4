package com.example.demo.repository;

import com.example.demo.model.Host;
import com.example.demo.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {

    Iterable<House> findAllBySoLuongPhongNguLessThanEqualAndTrangThai(int soLuongPhongNgu, String trangThai);

    Iterable<House> findAllBySoLuongPhongTamLessThanEqualAndTrangThai(int soLuongPhongTam, String trangThai);

    Iterable<House> findAllByDiaChiContainsAndTrangThai(String diaChi, String trangThai);

    Iterable<House> findAllByGiaTienTheoDemBetweenAndTrangThai(Double dauDuoi, Double dauTren, String trangThai);

    Iterable<House> findAllByTrangThai(String trangThai);

    Iterable<House> findAllByHost(Host host);
}
