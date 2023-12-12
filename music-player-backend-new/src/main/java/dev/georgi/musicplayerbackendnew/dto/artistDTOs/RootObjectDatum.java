package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RootObjectDatum {
    private PurpleAttributes attributes;
    private String avatar;
    private String href;
    private String id;
    private Meta meta;
    private PurpleRelationships relationships;
    private Type type;
    private DatumViews views;
}
