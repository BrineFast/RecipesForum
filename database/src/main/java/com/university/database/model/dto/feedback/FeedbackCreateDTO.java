package com.university.database.model.dto.feedback;

import lombok.Data;

@Data
public class FeedbackCreateDTO {

    private String title;
    private String text;

    private Integer mark;

}
