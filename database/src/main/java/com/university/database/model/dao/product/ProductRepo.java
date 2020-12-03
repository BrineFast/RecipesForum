package com.university.database.model.dao.product;

import com.university.database.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select p.name, p.price, c.water, c.protein, c.fats, c.carbohydrates, c.calories, s.name, cntr.name, pt.name from Product p " +
            "join Composition c on p.compositionId.id = c.id " +
            "join Season s on  p.countryId.id = s.id " +
            "join ProductType pt on p.typeId.id = pt.id " +
            "join Country cntr on p.countryId.id = cntr.id " +
            "where p.id = :pid")
    Optional<Product> findProduct(@Param("pid") Long id);

}
