package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Share {
    private String avatar;
    private String href;
    private String html;
    private String image;
    private String snapchat;
    private String subject;
    private String text;
    private String twitter;
}
