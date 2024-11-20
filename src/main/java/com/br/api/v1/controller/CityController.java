package com.br.api.v1.controller;

import com.br.domain.model.City;
import com.br.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public List<City> list() {
        return cityService.list();
    }

}
