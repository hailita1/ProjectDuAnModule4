package com.example.demo.controller;

import com.example.demo.model.Host;
import com.example.demo.model.House;
import com.example.demo.model.Image;
import com.example.demo.service.impl.HouseServiceImpl;
import com.example.demo.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin("*")
@RestController
public class HouseController {
    @Autowired
    private HouseServiceImpl houseService;

    @Autowired
    private ImageServiceImpl imageService;

    @RequestMapping(value = "/api/houses", method = RequestMethod.GET)
    public ResponseEntity<Iterable<House>> listAllHouse() {
        Iterable<House> houses = houseService.findAllByTrangThai("Trống");
        if (houses == null) {
            return new ResponseEntity<Iterable<House>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<House>>(houses, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/housesss", method = RequestMethod.GET)
    public ResponseEntity<Iterable<House>> listAllHouse1() {
        Iterable<House> houses = houseService.findAll();
        if (houses == null) {
            return new ResponseEntity<Iterable<House>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<House>>(houses, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/houses/{id}", method = RequestMethod.GET)
    public ResponseEntity<House> getHouse(@PathVariable("id") Long id) {
        House house = houseService.findById(id);
        if (house == null) {
            return new ResponseEntity<House>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<House>(house, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/houses", method = RequestMethod.POST)
    public ResponseEntity<Void> createHouse(@RequestBody House house, UriComponentsBuilder ucBuilder) {
        houseService.save(house);
        for (Image image : house.getPicture()) {
            image.setHouse(house);
            imageService.save(image);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/houses/{id}").buildAndExpand(house.getIdNha()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/houses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<House> updateHouse(@PathVariable("id") Long id, @RequestBody House house) {
        House houseServiceById = houseService.findById(id);
        List<Image> imageListFound = houseServiceById.getPicture(); // mang anh goc
        if (houseServiceById == null) {
            return new ResponseEntity<House>(HttpStatus.NOT_FOUND);
        }
        houseServiceById.setTenNha(house.getTenNha());
        houseServiceById.setDiaChi(house.getDiaChi());
        houseServiceById.setSoLuongPhongNgu(house.getSoLuongPhongNgu());
        houseServiceById.setSoLuongPhongTam(house.getSoLuongPhongTam());
        houseServiceById.setMoTaChung(house.getMoTaChung());
        houseServiceById.setGiaTienTheoDem(house.getGiaTienTheoDem());
        houseServiceById.setTrangThai(house.getTrangThai());
        houseServiceById.setCategoryHouse(house.getCategoryHouse());
        houseServiceById.setCategoryRoom(house.getCategoryRoom());
        List<Image> imageList = house.getPicture(); // mang anh lay ve
        for (Image image : imageList) {
            if (image.getIdAnh() == null) {
                image.setHouse(houseServiceById);
                imageService.save(image);
            } else {
                imageService.remove(image.getIdAnh());
            }
        }
        houseService.save(houseServiceById);
        return new ResponseEntity<House>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/houses/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<House> deleteHouse(@PathVariable("id") Long id) {
        House house = houseService.findById(id);
        if (house == null) {
            return new ResponseEntity<House>(HttpStatus.NOT_FOUND);
        }
        houseService.remove(id);
        return new ResponseEntity<House>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/findAllBySoLuongPhongNguLessThanEqualAndTrangThai")
    public ResponseEntity<Iterable<House>> findAllBySoLuongPhongNguAndTrangThai(@RequestParam("house") String house, String type) {
        Iterable<House> houses = houseService.findAllBySoLuongPhongNguLessThanEqualAndTrangThai(Integer.parseInt(house), "Trống");
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/findAllBySoLuongPhongTamLessThanEqualAndTrangThai")
    public ResponseEntity<Iterable<House>> findAllBySoLuongPhongTamLessThanEqualAndTrangThai(@RequestParam("house") String house) {
        Iterable<House> houses = houseService.findAllBySoLuongPhongTamLessThanEqualAndTrangThai(Integer.parseInt(house), "Trống");
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }


    @GetMapping("/api/findAllByDiaChiContainsAndTrangThai")
    public ResponseEntity<Iterable<House>> findAllByDiaChiContainsAndTrangThai(@RequestParam("house") String house) {
        Iterable<House> houses = houseService.findAllByDiaChiContainsAndTrangThai(house, "Trống");
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/findAllByGiaTienTheoDemBetweenAndTrangThai")
    public ResponseEntity<Iterable<House>> findAllByGiaTienTheoDemBetweenAndTrangThai(@RequestParam("dauDuoi") String dauDuoi, @RequestParam("dauTren") String dauTren) {
        Iterable<House> houses = houseService.findAllByGiaTienTheoDemBetweenAndTrangThai(Double.parseDouble(dauDuoi), Double.parseDouble(dauTren), "Trống");
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/findAllByHost")
    public ResponseEntity<Iterable<House>> findAllByHost(@RequestParam("host") Host id) {
        Iterable<House> houses = houseService.findAllByHost(id);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
}
