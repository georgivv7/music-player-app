package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hub {
    private Action[] actions;
    private String displayname;
    private boolean explicit;
    private String image;
    private Option[] options;
    private String type;
}
