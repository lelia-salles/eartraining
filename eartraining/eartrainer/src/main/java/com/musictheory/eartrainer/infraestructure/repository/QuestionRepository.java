package com.musictheory.eartrainer.infraestructure.repository;

import com.musictheory.eartrainer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
