package com.university.database.model.dao;

import com.university.database.model.entity.season.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepo extends JpaRepository<Season, Long> {
}
