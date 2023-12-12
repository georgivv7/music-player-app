package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurpleAttributes {
    private String artistBio;
    private Artwork artwork;
    private String bornOrFormed;
    private PurpleEditorialArtwork editorialArtwork;
    private String[] genreNames;
    private String name;
    private String origin;
    private String url;
}
