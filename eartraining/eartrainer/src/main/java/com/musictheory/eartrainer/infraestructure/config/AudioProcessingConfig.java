package com.musictheory.eartrainer.infraestructure.config;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AudioProcessingConfig {

    @Bean
    public AudioDispatcher audioDispatcher() {
        return AudioDispatcherFactory.fromDefaultMicrophone(44100, 2048, 1024);
    }
}
