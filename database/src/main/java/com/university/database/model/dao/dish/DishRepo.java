package com.university.database.model.dao.dish;

import com.university.database.model.entity.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<Dish, Long> {
}
