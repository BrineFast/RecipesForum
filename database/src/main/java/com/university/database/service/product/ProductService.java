package com.university.database.service.product;

import com.university.database.exception.entities.ItemNotFoundException;
import com.university.database.model.dao.country.CountryRepo;
import com.university.database.model.dao.product.CompositionRepo;
import com.university.database.model.dao.product.ProductRepo;
import com.university.database.model.dao.product.ProductTypeRepo;
import com.university.database.model.dao.season.SeasonRepo;
import com.university.database.model.dto.product.ProductCreateDTO;
import com.university.database.model.dto.product.ProductEditDTO;
import com.university.database.model.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CompositionRepo compositionRepo;

    @Autowired
    ProductTypeRepo productTypeRepo;

    @Autowired
    SeasonRepo seasonRepo;

    @Autowired
    CountryRepo countryRepo;


    public List<Product> getProductsList(){
        return productRepo.findAll();
    }

    @Transactional
    public Product createProduct(ProductCreateDTO productCreateDTO){
        Product product = new Product();
        product.setCompositionId(compositionRepo.findById(productCreateDTO.getCompositionId())
                .orElseThrow(() -> new ItemNotFoundException("Composition with id " + productCreateDTO.getCompositionId().toString() +  " not found.")));
        product.setCountryId(countryRepo.findById(productCreateDTO.getCountryId()).orElseThrow(() -> new ItemNotFoundException("Country with id " + productCreateDTO.getCountryId().toString() +  " not found.")));
        product.setSeasonId(seasonRepo.findById(productCreateDTO.getSeasonId()).orElseThrow(() -> new ItemNotFoundException("Season with id " + productCreateDTO.getSeasonId().toString() +  " not found.")));
        product.setTypeId(productTypeRepo.findById(productCreateDTO.getTypeId()).orElseThrow(() -> new ItemNotFoundException("Type with id " + productCreateDTO.getTypeId().toString() +  " not found.")));
        product.setName(productCreateDTO.getName());
        product.setPrice(productCreateDTO.getPrice());
        return productRepo.save(product);
    }

    public Product getProduct(Long productId){
        return productRepo.findById(productId).orElseThrow(() -> new ItemNotFoundException("Product with id " + productId.toString() +  " not found."));
    }

    @Transactional
    public Product editProduct(Long productId, ProductEditDTO productEditDTO){
        Product product = productRepo.findById(productId).orElseThrow(() -> new ItemNotFoundException("Composition with id " + productEditDTO.getCompositionId().toString() +  " not found."));
        product.setCompositionId(compositionRepo.findById(productEditDTO.getCompositionId())
                .orElseThrow(() -> new ItemNotFoundException("Composition with id " + productEditDTO.getCompositionId().toString() +  " not found.")));
        product.setCountryId(countryRepo.findById(productEditDTO.getCountryId()).orElseThrow(() -> new ItemNotFoundException("Country with id " + productEditDTO.getCountryId().toString() +  " not found.")));
        product.setSeasonId(seasonRepo.findById(productEditDTO.getSeasonId()).orElseThrow(() -> new ItemNotFoundException("Season with id " + productEditDTO.getSeasonId().toString() +  " not found.")));
        product.setTypeId(productTypeRepo.findById(productEditDTO.getTypeId()).orElseThrow(() -> new ItemNotFoundException("Type with id " + productEditDTO.getTypeId().toString() +  " not found.")));
        product.setName(productEditDTO.getName());
        product.setPrice(productEditDTO.getPrice());
        return productRepo.save(product);
    }

}
