package com.university.database.model.dao;

import com.university.database.model.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepo extends JpaRepository<ProductType, Long> {
}
