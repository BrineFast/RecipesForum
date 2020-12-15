package com.university.database.model.dao.dish;

import com.university.database.model.entity.dish.DishTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishTopRepo extends JpaRepository<DishTop, Long> {


    @Query(value = "exec most_popular_dish", nativeQuery = true)
    List<DishTop> most_popular_dish();

}
