package com.musictheory.eartrainer.domain.dto;
import java.util.List;

public class UserDTO {
    private String name;
    private String email;
    private String profileImage;
    private List<SocialLinkDTO> socialLinks;

    public UserDTO() {}

    public UserDTO(String name, String email, String profileImage, List<SocialLinkDTO> socialLinks) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
        this.socialLinks = socialLinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<SocialLinkDTO> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<SocialLinkDTO> socialLinks) {
        this.socialLinks = socialLinks;
    }
}