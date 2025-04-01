package com.musictheory.eartrainer.application.service;

import org.springframework.stereotype.Service;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.Oscillator;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.TarsosDSPInputStream;
import be.tarsos.dsp.util.fft.FFT;
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;


@Service
public class AudioProcessorService {


    private static final double SAMPLE_RATE = 44100.0;
    private static final int DURATION = 1000;
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

 
    public byte[] generateSound(String note, String difficulty) {
        double frequency = getFrequencyFromNote(note);        
        Oscillator oscillator = new Oscillator(frequency, SAMPLE_RATE);
        AudioOutputStream outputStream = new AudioOutputStream(new ByteArrayOutputStream());
        
        oscillator.setVolume(0.5); 
        oscillator.setFrequency(frequency); 
        oscillator.setDuration(DURATION); 

        try {
            oscillator.processAudioEvent(new AudioEvent(outputStream));
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.getByteArray();
    }

   
    public byte[] generateRandomInterval() {
        Random random = new Random();    
        String note1 = NOTES[random.nextInt(NOTES.length)];
        String note2 = NOTES[random.nextInt(NOTES.length)];
   
        byte[] note1Audio = generateSound(note1, "medium");
        byte[] note2Audio = generateSound(note2, "medium");    
        byte[] intervalAudio = concatenateAudio(note1Audio, note2Audio);

        return intervalAudio; 
    }
    
    public byte[] generateRandomChord() {
    
        Random random = new Random();   
        String rootNote = NOTES[random.nextInt(NOTES.length)];   
        String[] chordTypes = {"major", "minor"};
        String chordType = chordTypes[random.nextInt(chordTypes.length)];
         
        return generateChord(chordType, rootNote);

    }

    public byte[] generateChord(String chordType, String rootNote) {
        String[] chordNotes = getChordNotes(rootNote, chordType);
        ByteArrayOutputStream chordAudioStream = new ByteArrayOutputStream();

         for (String note : chordNotes) {
        byte[] noteAudio = generateSound(note, "medium");
        
        try {
            
            chordAudioStream.write(noteAudio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     return chordAudioStream.toByteArray();
}

    private byte[] concatenateAudio(byte[] audio1, byte[] audio2) {
        byte[] result = new byte[audio1.length + audio2.length];
        System.arraycopy(audio1, 0, result, 0, audio1.length);
        System.arraycopy(audio2, 0, result, audio1.length, audio2.length);
        return result;
    }

   
    private double getFrequencyFromNote(String note) {
        int index = getNoteIndex(note);
        if (index == -1) {
            return 0;
        }

        
        double[] frequencies = {
            261.63, 277.18, 293.66, 311.13, 329.63, 349.23, 369.99, 392.00, 415.30, 440.00, 466.16, 493.88
        };

        return frequencies[index];
    }

    
    private int getNoteIndex(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(note)) {
                return i;
            }
        }
        return -1;
    }

   
    private String[] getChordNotes(String rootNote, String chordType) {
        if ("major".equals(chordType)) {
            return new String[] { rootNote, getNoteAfter(rootNote, 4), getNoteAfter(rootNote, 7) };
        } else if ("minor".equals(chordType)) {
            return new String[] { rootNote, getNoteAfter(rootNote, 3), getNoteAfter(rootNote, 7) };
        }
        return new String[] {};
    }

    
    private String getNoteAfter(String note, int semitones) {
        int index = getNoteIndex(note);
        int newIndex = (index + semitones) % NOTES.length;
        return NOTES[newIndex];
    }
}