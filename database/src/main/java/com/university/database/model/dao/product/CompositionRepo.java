package com.university.database.model.dao.product;

import com.university.database.model.entity.product.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepo extends JpaRepository<Composition, Long> {

}
