package com.musictheory.eartrainer.test.repository;

import com.musictheory.eartrainer.application.model.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    void testSaveActivity() {
        Activity activity = new Activity();
        activity.setType("Ear Training");
        activityRepository.save(activity);

        assertNotNull(activity.getId());
    }
}