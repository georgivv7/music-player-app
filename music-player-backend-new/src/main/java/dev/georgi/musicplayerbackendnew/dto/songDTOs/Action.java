package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
    private String id;
    private String name;
    private String type;
    private String uri;
}
