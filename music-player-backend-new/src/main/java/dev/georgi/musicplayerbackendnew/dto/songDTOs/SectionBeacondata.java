package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionBeacondata {
    private String commontrackid;
    private String lyricsid;
    private String providername;

}
