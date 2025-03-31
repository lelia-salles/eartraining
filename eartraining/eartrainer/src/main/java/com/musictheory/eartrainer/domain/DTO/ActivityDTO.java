package com.musictheory.eartrainer.domain.dto;

import java.util.List;

public class ActivityDTO {
    private String type;
    private List<LevelDTO> levels;

    public ActivityDTO() {}

    public ActivityDTO(String type, List<LevelDTO> levels) {
        this.type = type;
        this.levels = levels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LevelDTO> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDTO> levels) {
        this.levels = levels;
    }
}
