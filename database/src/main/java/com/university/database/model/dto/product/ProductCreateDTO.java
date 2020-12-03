package com.university.database.model.dto.product;

import lombok.Data;

@Data
public class ProductCreateDTO {

    private String name;

    private Integer price;

    private Long compositionId;

    private Long typeId;

    private Long seasonId;

    private Long countryId;
}
