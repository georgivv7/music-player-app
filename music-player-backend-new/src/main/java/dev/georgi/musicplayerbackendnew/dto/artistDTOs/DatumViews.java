package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatumViews {
    private FeaturedAlbums featuredAlbums;
    private FeaturedAlbums fullAlbums;
    private FeaturedAlbums latestRelease;
    private FeaturedAlbums playlists;
    private FeaturedAlbums similarArtists;
    private FeaturedAlbums topMusicVideos;
    private FeaturedAlbums topSongs;
}
