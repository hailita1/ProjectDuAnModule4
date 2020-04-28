package com.example.demo.service.impl;

import com.example.demo.model.Host;
import com.example.demo.model.House;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Iterable<House> findAll() {
        return this.houseRepository.findAll();
    }

    @Override
    public House findById(Long id) {
        return this.houseRepository.findById(id).get();
    }

    @Override
    public void save(House house) {
        this.houseRepository.save(house);
    }

    @Override
    public void remove(Long id) {
        this.houseRepository.deleteById(id);
    }

    @Override
    public Iterable<House> findAllByTrangThai(String trangThai) {
        return houseRepository.findAllByTrangThai(trangThai);
    }

    @Override
    public Iterable<House> findAllByHost(Host host) {
        return houseRepository.findAllByHost(host);
    }

    //Tìm kiếm theo 1 tiêu chí
    @Override
    public Iterable<House> findAllByDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTamOrGiaTienTheoDemBetween(String diaChi, int slpn, int slpt, Double dauDuoi, Double dauTren) {
        return houseRepository.findAllByDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTamOrGiaTienTheoDemBetween(diaChi, slpn, slpt, dauDuoi, dauTren);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongNguOrDiaChiContainsOrSoLuongPhongTamOrGiaTienTheoDemBetween(int slpn, String diaChi, int slpt, Double dauDuoi, Double dauTren) {
        return houseRepository.findAllBySoLuongPhongNguOrDiaChiContainsOrSoLuongPhongTamOrGiaTienTheoDemBetween(slpn, diaChi, slpt, dauDuoi, dauTren);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongTamOrDiaChiContainsOrSoLuongPhongNguOrGiaTienTheoDemBetween(int slpt, String diaChi, int slpn, Double dauDuoi, Double dauTren) {
        return houseRepository.findAllBySoLuongPhongTamOrDiaChiContainsOrSoLuongPhongNguOrGiaTienTheoDemBetween(slpt, diaChi, slpn, dauDuoi, dauTren);
    }


    @Override
    public Iterable<House> findAllByGiaTienTheoDemBetweenOrDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTam(Double dauDuoi, Double dauTren, String diaChi, int slpn, int slpt) {
        return houseRepository.findAllByGiaTienTheoDemBetweenOrDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTam(dauDuoi, dauTren, diaChi, slpn, slpt);
    }

    //Tìm kiếm theo 2 tiêu chí
    @Override
    public Iterable<House> findAllByDiaChiContainsAndSoLuongPhongTamOrSoLuongPhongNguOrGiaTienTheoDemBetween(String diaChi, int slpt, int slpn, Double dauDuoi, Double dauTren) {
        return houseRepository.findAllByDiaChiContainsAndSoLuongPhongTamOrSoLuongPhongNguOrGiaTienTheoDemBetween(diaChi, slpt, slpn, dauDuoi, dauTren);
    }
}
