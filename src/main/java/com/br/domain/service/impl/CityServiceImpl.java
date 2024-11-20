package com.br.domain.service.impl;

import com.br.domain.model.City;
import com.br.domain.repository.CityRepository;
import com.br.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> list() {
        return cityRepository.findAll();
    }

}
