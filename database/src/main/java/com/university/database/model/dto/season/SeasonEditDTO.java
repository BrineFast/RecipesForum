package com.university.database.model.dto.season;

import lombok.Data;

import java.util.Date;

@Data
public class SeasonEditDTO {

    private String name;

    private Date start_date;

    private Date end_date;

}
