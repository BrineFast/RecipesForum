package com.university.database.model.entity.season;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

}
