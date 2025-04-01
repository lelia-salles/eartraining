package com.musictheory.eartrainer.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tensorflow.SavedModelBundle;

@Configuration
public class MLConfig {

    private static final String MODEL_PATH = "src/main/resources/ml-model";

    @Bean
    public SavedModelBundle loadTensorFlowModel() {
        return SavedModelBundle.load(MODEL_PATH, "serve");
    }
}
