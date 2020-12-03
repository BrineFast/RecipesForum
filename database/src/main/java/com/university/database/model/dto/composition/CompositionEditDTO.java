package com.university.database.model.dto.composition;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CompositionEditDTO {

    @Max(100)
    @Min(1)
    private Double water;

    @Max(100)
    @Min(1)
    private Double protein;

    @Max(100)
    @Min(1)
    private Double fats;

    @Max(100)
    @Min(1)
    private Double carbohydrates;

    @Max(500)
    @Min(1)
    private Double calories;

}
