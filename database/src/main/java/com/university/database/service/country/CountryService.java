package com.university.database.service.country;

import com.university.database.exception.entities.ItemNotFoundException;
import com.university.database.model.dao.country.CountryRepo;
import com.university.database.model.dto.country.CountryCreateDTO;
import com.university.database.model.dto.country.CountryEditDTO;
import com.university.database.model.entity.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class CountryService {

    @Autowired
    CountryRepo countryRepo;

    @Transactional
    public Country createCountry(CountryCreateDTO countryCreateDTO){
        Country country = new Country();
        country.setName(countryCreateDTO.getName());
        return countryRepo.save(country);
    }

    public List<Country> getCountriesList(){
        return countryRepo.findAll();
    }

    public Country getCountry(Long countryId){
        return countryRepo.findById(countryId).orElseThrow(() -> new ItemNotFoundException("Country with id " + countryId +  " not found."));
    }

    @Transactional
    public Country editCountry(Long countryId, CountryEditDTO countryEditDTO){
        Country country = countryRepo.findById(countryId).orElseThrow(() -> new ItemNotFoundException("Country with id " + countryId +  " not found."));
        country.setName(countryEditDTO.getName());
        return countryRepo.save(country);
    }
}
