package com.university.database.service;

import com.university.database.exception.BadDataException;
import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.SeasonRepo;
import com.university.database.model.dto.season.SeasonCreateDTO;
import com.university.database.model.dto.season.SeasonEditDTO;
import com.university.database.model.entity.season.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class SeasonService {

    @Autowired
    SeasonRepo seasonRepo;

    public List<Season> getSeasonsList(){
        return seasonRepo.findAll();
    }

    public Season getSeason(Long seasonId){
        return seasonRepo.findById(seasonId).orElseThrow(() -> new ProductNotFoundException("Season with id " + seasonId + " not found."));
    }

    @Transactional
    public Season createSeason(SeasonCreateDTO seasonCreateDTO){
        Season season = new Season();
        if (seasonCreateDTO.getStart_date().after(seasonCreateDTO.getEnd_date()))
            throw new BadDataException("The start date cannot be after the end date");
        season.setStart_date(seasonCreateDTO.getStart_date());
        season.setEnd_date(seasonCreateDTO.getEnd_date());
        season.setName(season.getName());
        return seasonRepo.save(season);
    }

    @Transactional
    public Season editSeason(Long seasonId, SeasonEditDTO seasonEditDTO){
        Season season = seasonRepo.findById(seasonId).orElseThrow(() -> new ProductNotFoundException("Season with id " + seasonId + " not found."));
        season.setName(seasonEditDTO.getName());
        season.setStart_date(seasonEditDTO.getStart_date());
        season.setEnd_date(seasonEditDTO.getEnd_date());
        return seasonRepo.save(season);
    }
}
