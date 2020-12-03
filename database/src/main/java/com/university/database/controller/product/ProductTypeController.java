package com.university.database.controller.product;

import com.university.database.model.dto.product.ProductTypeCreateDTO;
import com.university.database.model.dto.product.ProductTypeEditDTO;
import com.university.database.model.entity.product.ProductType;
import com.university.database.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("/product_types")
    public List<ProductType> getRecipeGroupsList(){
        return productTypeService.getRecipeGroupsList();
    }

    @GetMapping("/product_types/{id}")
    public ProductType getRecipeGroup(@PathVariable("id") Long productTypeId){
        return productTypeService.getRecipeGroup(productTypeId);
    }

    @PostMapping("/product_types/create")
    public ProductType createRecipeGroup(@RequestBody ProductTypeCreateDTO productTypeCreateDTO){
        return productTypeService.createRecipeGroup(productTypeCreateDTO);
    }

    @PatchMapping("/product_types/{id}")
    public ProductType editRecipeGroup(@PathVariable("id") Long productTypeId, @RequestBody ProductTypeEditDTO productTypeEditDTO){
        return productTypeService.editRecipeGroup(productTypeId, productTypeEditDTO);
    }

}
