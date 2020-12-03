package com.university.database.service;

import com.university.database.exception.ProductNotFoundException;
import com.university.database.model.dao.ProductTypeRepo;
import com.university.database.model.dto.product.ProductTypeCreateDTO;
import com.university.database.model.dto.product.ProductTypeEditDTO;
import com.university.database.model.entity.product.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class ProductTypeService {

    @Autowired
    ProductTypeRepo productTypeRepo;

    public List<ProductType> getRecipeGroupsList(){
        return productTypeRepo.findAll();
    }

    public ProductType getRecipeGroup(Long productTypeId){
        return productTypeRepo.findById(productTypeId).orElseThrow(() -> new ProductNotFoundException("ProductType with id " + productTypeId.toString() + " not found."));
    }

    @Transactional
    public ProductType createRecipeGroup(ProductTypeCreateDTO productTypeCreateDTO){
        ProductType productType = new ProductType();
        productType.setName(productTypeCreateDTO.getName());
        return productTypeRepo.save(productType);
    }

    @Transactional
    public ProductType editRecipeGroup(Long productTypeId, ProductTypeEditDTO productTypeEditDTO){
        ProductType productType = productTypeRepo.findById(productTypeId).orElseThrow(() -> new ProductNotFoundException("ProductType with id " + productTypeId.toString() + " not found."));
        productType.setName(productTypeEditDTO.getName());
        return productTypeRepo.save(productType);
    }

}
