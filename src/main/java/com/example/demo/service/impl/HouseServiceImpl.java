package com.example.demo.service.impl;

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
    public Iterable<House> findAllBySoLuongPhongNguContains(String soLuongPhongNgu) {
        return houseRepository.findAllBySoLuongPhongNguContains(soLuongPhongNgu);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongTamContains(String soLuongPhongTam) {
        return houseRepository.findAllBySoLuongPhongTamContains(soLuongPhongTam);
    }

    @Override
    public Iterable<House> findAllByDiaChiContains(String diaChi) {
        return houseRepository.findAllByDiaChiContains(diaChi);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongNguContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String soLuongPhongTam) {
        return houseRepository.findAllBySoLuongPhongNguContainsOrSoLuongPhongTamContains(soLuongPhongNgu, soLuongPhongTam);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContains(String soLuongPhongNgu, String diaChi) {
        return houseRepository.findAllBySoLuongPhongNguContainsOrDiaChiContains(soLuongPhongNgu, diaChi);
    }

    @Override
    public Iterable<House> findAllBySoLuongPhongNguContainsOrDiaChiContainsOrSoLuongPhongTamContains(String soLuongPhongNgu, String diaChi, String soLuongPhongTam) {
        return houseRepository.findAllBySoLuongPhongNguContainsOrDiaChiContainsOrSoLuongPhongTamContains(soLuongPhongNgu, diaChi, soLuongPhongTam);
    }
}
