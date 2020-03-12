package com.example.demo.service;

import com.example.demo.model.Image;

public interface ImageService {
    Iterable<Image> findAll();

    Image findById(Long id);

    void save(Image image);

    void remove(Long id);
}
