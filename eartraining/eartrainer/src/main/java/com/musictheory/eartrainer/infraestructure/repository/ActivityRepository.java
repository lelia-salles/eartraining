package com.musictheory.eartrainer.infrastructure.repository;

import com.musictheory.eartrainer.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
