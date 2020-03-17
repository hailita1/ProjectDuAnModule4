package com.example.demo.controller;

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
        Iterable<House> houses = houseService.findAll();
        House house1 = new House();
        for (House house2 : houses) {
            house1 = house2;
        }
        for (Image picture : house.getPicture()) {
            picture.setHouse(house1);
            imageService.save(picture);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/houses/{id}").buildAndExpand(house.getIdNha()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/houses/{id}", method = RequestMethod.PUT)
    public ResponseEntity<House> updateHouse(@PathVariable("id") Long id, @RequestBody House house) {
        House houseServiceById = houseService.findById(id);

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

    @GetMapping("/api/findAllBySoLuongPhongNguContains")
    public ResponseEntity<Iterable<House>> findAllBySoLuongPhongNguContains(@RequestParam("house") String house) {
        Iterable<House> houses = houseService.findAllBySoLuongPhongNguContains(house);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/findAllBySoLuongPhongTamContains")
    public ResponseEntity<Iterable<House>> findAllBySoLuongPhongTamContains(@RequestParam("house") String house) {
        Iterable<House> houses = houseService.findAllBySoLuongPhongTamContains(house);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }


    @GetMapping("/api/findAllByDiaChiContains")
    public ResponseEntity<Iterable<House>> findAllByDiaChiContains(@RequestParam("house") String house) {
        Iterable<House> houses = houseService.findAllByDiaChiContains(house);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/findAllByGiaTienTheoDemBetween")
    public ResponseEntity<Iterable<House>> findAllByGiaTienTheoDemBetween(@RequestParam("dauDuoi") String dauDuoi, @RequestParam("dauTren") String dauTren) {
        Iterable<House> houses = houseService.findAllByGiaTienTheoDemBetween(Double.parseDouble(dauDuoi), Double.parseDouble(dauTren));
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }


}
