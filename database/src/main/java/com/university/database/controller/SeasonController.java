package com.university.database.controller;

import com.university.database.model.dto.season.SeasonCreateDTO;
import com.university.database.model.dto.season.SeasonEditDTO;
import com.university.database.model.entity.season.Season;
import com.university.database.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeasonController {

    @Autowired
    SeasonService seasonService;

    @GetMapping("/seasons")
    public List<Season> getSeasonsList(){
        return seasonService.getSeasonsList();
    }

    @GetMapping("/seasons/{id}")
    public Season getSeason(@PathVariable("id") Long seasonId){
        return seasonService.getSeason(seasonId);
    }

    @PostMapping("/seasons/create")
    public Season createSeason(@RequestBody SeasonCreateDTO seasonCreateDTO){
        return seasonService.createSeason(seasonCreateDTO);
    }

    @PatchMapping("/seasons/{id}")
    public Season editSeason(@PathVariable("id") Long seasonId, @RequestBody SeasonEditDTO seasonEditDTO){
        return seasonService.editSeason(seasonId, seasonEditDTO);
    }

}
