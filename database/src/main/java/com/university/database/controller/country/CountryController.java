package com.university.database.controller.country;

import com.university.database.model.dto.country.CountryCreateDTO;
import com.university.database.model.dto.country.CountryEditDTO;
import com.university.database.model.entity.country.Country;
import com.university.database.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping("/countries/create")
    public Country createCountry(@RequestBody CountryCreateDTO countryCreateDTO){
        return countryService.createCountry(countryCreateDTO);
    }

    @GetMapping("/countries")
    public List<Country> getCountriesList(){
        return countryService.getCountriesList();
    }

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable("id") Long countryId){
        return countryService.getCountry(countryId);
    }

    @PostMapping("/countries/{id}")
    public Country editCountry(@PathVariable("id") Long countryId, @RequestBody CountryEditDTO countryEditDTO){
        return countryService.editCountry(countryId, countryEditDTO);
    }
}
