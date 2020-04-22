package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Deal;
import com.example.demo.model.House;
import com.example.demo.model.Image;
import com.example.demo.service.impl.DealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin("*")
@RestController
public class DealController {
    @Autowired
    private DealServiceImpl dealService;

    @RequestMapping(value = "/api/deals", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Deal>> listAllDeal() {
        Iterable<Deal> deals = dealService.findAll();
        if (deals == null) {
            return new ResponseEntity<Iterable<Deal>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Deal>>(deals, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/deals/{id}", method = RequestMethod.GET)
    public ResponseEntity<Deal> getDeal(@PathVariable("id") Long id) {
        Deal deal = dealService.findById(id);
        if (deal == null) {
            return new ResponseEntity<Deal>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Deal>(deal, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/deals", method = RequestMethod.POST)
    public ResponseEntity<Void> createDeal(@RequestBody Deal deal, UriComponentsBuilder ucBuilder) {
        dealService.save(deal);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/deals/{id}").buildAndExpand(deal.getIdGiaoDich()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/api/deals/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Deal> updateDeal(@PathVariable("id") Long id, @RequestBody Deal deal) {
        Deal deal1 = dealService.findById(id);

        if (deal1 == null) {
            return new ResponseEntity<Deal>(HttpStatus.NOT_FOUND);
        }
        deal1.setNgayDen(deal.getNgayDen());
        deal1.setNgayDi(deal.getNgayDi());
        deal1.setDanhGia(deal.getDanhGia());
        deal1.setTrangThai(deal.getTrangThai());
        deal1.setThanhTien(deal.getThanhTien());
        deal1.setPhanHoi(deal.getPhanHoi());
        deal1.setHouse(deal.getHouse());
        deal1.setCustomer(deal.getCustomer());
        dealService.save(deal1);
        return new ResponseEntity<Deal>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/deals/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Deal> deleteDeal(@PathVariable("id") Long id) {
        Deal deal = dealService.findById(id);
        if (deal == null) {
            return new ResponseEntity<Deal>(HttpStatus.NOT_FOUND);
        }
        dealService.remove(id);
        return new ResponseEntity<Deal>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/findAllCustomer")
    public ResponseEntity<Iterable<Deal>> findAllCustomer(@RequestParam("customer") Customer id) {
        Iterable<Deal> deals = dealService.findAllByCustomer(id);
        if (deals == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deals, HttpStatus.OK);
    }
}
