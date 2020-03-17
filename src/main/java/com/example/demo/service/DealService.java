package com.example.demo.service;

import com.example.demo.model.Deal;

public interface DealService {
    Iterable<Deal> findAll();

    Deal findById(Long id);

    void save(Deal deal);

    void remove(Long id);
}
