package com.example.demo.service;

import com.example.demo.models.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CountryService {

    public List<Country> findAll();

    public Optional<Country> findById(Long id);

    public Optional<Country> save(String name,String continent);

    public Optional<Country> edit(Long id,String name,String continent);

    public void deleteById(Long id);


}
