package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeaturedAlbums {
    private FeaturedAlbumsAttributes attributes;
    private FeaturedAlbumsDatum[] data;
    private String href;
    private String next;
}
