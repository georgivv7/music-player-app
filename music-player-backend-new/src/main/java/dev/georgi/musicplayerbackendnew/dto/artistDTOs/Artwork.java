package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artwork {
    private String bgColor;
    private boolean hasP3;
    private long height;
    private String textColor1;
    private String textColor2;
    private String textColor3;
    private String textColor4;
    private String url;
    private long width;
}
