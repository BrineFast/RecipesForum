package com.university.database.model.dto.season;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
public class SeasonCreateDTO {

    private String name;

    private Date start_date;

    private Date end_date;

}
