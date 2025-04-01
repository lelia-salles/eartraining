package com.musictheory.eartrainer.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioProcessingUtil {

    public static void playAudio(byte[] audioData) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new ByteArrayInputStream(audioData));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public static void saveAudioFile(byte[] audioData, String filePath) throws IOException {
        File file = new File(filePath);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(audioData)) {
            AudioSystem.write(AudioSystem.getAudioInputStream(bais), AudioFileFormat.Type.WAVE, file);
        }
    }
}
