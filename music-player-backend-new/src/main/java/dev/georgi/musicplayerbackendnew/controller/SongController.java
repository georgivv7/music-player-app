package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.SongService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SongController{
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs/{songId}")
    public JsonNode getSongDetails(@PathVariable String songId) {
        return songService.fetchSongDetails(songId);
    }

    @GetMapping("/songs/related/{songId}")
    public JsonNode getRelatedSongs(@PathVariable String songId)  {
        return songService.fetchRelatedSongs(songId);
    }

    @GetMapping("/around-you/{countryCode}")
    public JsonNode getSongsByCountry(@PathVariable String countryCode)  {
        return songService.fetchSongsAroundYou(countryCode);
    }

}