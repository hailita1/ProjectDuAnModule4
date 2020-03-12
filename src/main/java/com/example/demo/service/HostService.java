package com.example.demo.service;

import com.example.demo.model.Host;
import com.example.demo.model.House;

public interface HostService {
    Iterable<Host> findAll();

    Host findById(Long id);

    void save(Host host);

    void remove(Long id);
}
