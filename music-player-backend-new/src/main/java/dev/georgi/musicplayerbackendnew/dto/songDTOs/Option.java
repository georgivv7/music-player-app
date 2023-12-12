package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Option {
    private Action[] actions;
    private OptionBeacondata beacondata;
    private String caption;
    private boolean colouroverflowimage;
    private String image;
    private String listcaption;
    private String overflowimage;
    private String providername;
    private String type;
}
