package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeaturedAlbumsDatum {
    private TentacledAttributes attributes;
    private String href;
    private String id;
    private FluffyRelationships relationships;
    private Type type;
}
