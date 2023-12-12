package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FluffyAttributes {
    private String albumName;
    private String artistName;
    private Artwork artwork;
    private AudioLocale audioLocale;
    private AudioTrait[] audioTraits;
    private String composerName;
    private String contentRating;
    private String copyright;
    private Long discNumber;
    private Long durationInMillis;
    private FluffyEditorialArtwork editorialArtwork;
    private EditorialNotes editorialNotes;
    private String[] genreNames;
    private Boolean has4K;
    private Boolean hasCredits;
    private Boolean hasHDR;
    private Boolean hasLyrics;
    private Boolean hasTimeSyncedLyrics;
    private Boolean isAppleDigitalMaster;
    private Boolean isCompilation;
    private Boolean isComplete;
    private Boolean isMasteredForItunes;
    private Boolean isPrerelease;
    private Boolean isSingle;
    private Boolean isVocalAttenuationAllowed;
    private String isrc;
    private String name;
    private PlayParams playParams;
    private Preview[] previews;
    private String recordLabel;
    private LocalDate releaseDate;
    private Long trackCount;
    private Long trackNumber;
    private String upc;
    private String url;
    private String[] videoTraits;
}
