package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Deal;
import com.example.demo.model.House;

public interface DealService {
    Iterable<Deal> findAll();

    Deal findById(Long id);

    void save(Deal deal);

    void remove(Long id);

    Iterable<Deal> findAllByCustomer(Customer customer);

    Iterable<Deal> findAllByHouse(House house);
}
