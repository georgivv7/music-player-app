package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {
    private SectionBeacondata beacondata;
    private String footer;
    private Metadatum[] metadata;
    private Metapage[] metapages;
    private String tabname;
    private String[] text;
    private String type;
}
