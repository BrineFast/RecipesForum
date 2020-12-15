package com.university.database.controller.product;

import com.university.database.model.dto.product.ProductCreateDTO;
import com.university.database.model.dto.product.ProductEditDTO;
import com.university.database.model.entity.product.Product;
import com.university.database.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProductsList(){
        return productService.getProductsList();
    }

    @PostMapping("/products/create")
    public Product createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        return productService.createProduct(productCreateDTO);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getProduct(productId);
    }

    @PatchMapping("/products/{id}")
    public Product editProduct(@PathVariable("id") Long productId, @RequestBody ProductEditDTO productEditDTO){
        return productService.editProduct(productId, productEditDTO);
    }
}
