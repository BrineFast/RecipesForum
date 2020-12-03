package com.university.database.model.dao.feedback;

import com.university.database.model.entity.feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
}
