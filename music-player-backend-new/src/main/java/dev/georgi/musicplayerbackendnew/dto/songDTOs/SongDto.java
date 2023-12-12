package dev.georgi.musicplayerbackendnew.dto.songDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.georgi.musicplayerbackendnew.dto.artistDTOs.Artist;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SongDto {
    private String albumadamid;
    private String alias;
    private Artist[] artists;
    private Genres genres;
    private Highlightsurls highlightsurls;
    private Hub hub;
    private Images images;
    private String isrc;
    private String key;
    private String layout;
    private String releasedate;
    private Section[] sections;
    private Share share;
    private String subtitle;
    private String title;
    private String trackadamid;
    private String type;
    private String url;
    private Urlparams urlparams;
}
