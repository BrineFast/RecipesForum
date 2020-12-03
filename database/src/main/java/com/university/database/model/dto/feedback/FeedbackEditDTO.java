package com.university.database.model.dto.feedback;

import lombok.Data;

@Data
public class FeedbackEditDTO {

    private String title;
    private String text;

    private Integer mark;

}
