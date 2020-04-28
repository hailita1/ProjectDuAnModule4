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
    private String trangThai = "Trống";

    @RequestMapping(value = "/api/houses", method = RequestMethod.GET)
    public ResponseEntity<Iterable<House>> listAllHouse() {
        Iterable<House> houses = houseService.findAllByTrangThai(trangThai);
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

    @RequestMapping(value = "/api/housesss/{id}", method = RequestMethod.PUT)
    public ResponseEntity<House> updateHouses(@PathVariable("id") Long id, @RequestBody House house) {
        House houseServiceById = houseService.findById(id);
        List<Image> imageListFound = houseServiceById.getPicture(); // mang anh goc
        if (houseServiceById == null) {
            return new ResponseEntity<House>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/api/findAllByHost")
    public ResponseEntity<Iterable<House>> findAllByHost(@RequestParam("host") Host id) {
        Iterable<House> houses = houseService.findAllByHost(id);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/searchs1")
    public ResponseEntity<Iterable<House>> Seach1(@RequestParam("diaChi") String diaChi,
                                                  @RequestParam("slpn") String slpn,
                                                  @RequestParam("slpt") String slpt,
                                                  @RequestParam("dauTren") String dauTren,
                                                  @RequestParam("dauDuoi") String dauDuoi) {

        Iterable<House> houses = houseService.findAllByTrangThai(trangThai);
        houses = houseService.findAllByDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTamOrGiaTienTheoDemBetween(diaChi, Integer.parseInt(slpn), Integer.parseInt(slpt), Double.parseDouble(dauDuoi), Double.parseDouble(dauTren));
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/searchs2")
    public ResponseEntity<Iterable<House>> Seach2(@RequestParam("diaChi") String diaChi,
                                                  @RequestParam("slpn") String slpn,
                                                  @RequestParam("slpt") String slpt,
                                                  @RequestParam("dauTren") String dauTren,
                                                  @RequestParam("dauDuoi") String dauDuoi) {
        Iterable<House> houses = houseService.findAllByTrangThai(trangThai);
        houses = houseService.findAllBySoLuongPhongNguOrDiaChiContainsOrSoLuongPhongTamOrGiaTienTheoDemBetween(Integer.parseInt(slpn), diaChi, Integer.parseInt(slpt), Double.parseDouble(dauDuoi), Double.parseDouble(dauTren));
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/searchs3")
    public ResponseEntity<Iterable<House>> Seach3(@RequestParam("diaChi") String diaChi,
                                                  @RequestParam("slpn") String slpn,
                                                  @RequestParam("slpt") String slpt,
                                                  @RequestParam("dauTren") String dauTren,
                                                  @RequestParam("dauDuoi") String dauDuoi) {
        Iterable<House> houses = houseService.findAllByTrangThai(trangThai);
        houses = houseService.findAllBySoLuongPhongTamOrDiaChiContainsOrSoLuongPhongNguOrGiaTienTheoDemBetween(Integer.parseInt(slpt), diaChi, Integer.parseInt(slpn), Double.parseDouble(dauDuoi), Double.parseDouble(dauTren));
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping("/api/searchs4")
    public ResponseEntity<Iterable<House>> Seach4(@RequestParam("diaChi") String diaChi,
                                                  @RequestParam("slpn") String slpn,
                                                  @RequestParam("slpt") String slpt,
                                                  @RequestParam("dauTren") String dauTren,
                                                  @RequestParam("dauDuoi") String dauDuoi) {
        Iterable<House> houses = houseService.findAllByTrangThai(trangThai);
        houses = houseService.findAllByGiaTienTheoDemBetweenOrDiaChiContainsOrSoLuongPhongNguOrSoLuongPhongTam(Double.parseDouble(dauDuoi), Double.parseDouble(dauTren), diaChi, Integer.parseInt(slpn), Integer.parseInt(slpt));
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }
}
