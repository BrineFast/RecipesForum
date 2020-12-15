package com.university.database.model.dao.dish;

import com.university.database.model.entity.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DishRepo extends JpaRepository<Dish, Long> {
}

