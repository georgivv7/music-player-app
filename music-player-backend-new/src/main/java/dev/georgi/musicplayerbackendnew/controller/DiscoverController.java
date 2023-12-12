package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.DiscoverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DiscoverController {
    private final DiscoverService discoverService;

    public DiscoverController(DiscoverService discoverService) {
        this.discoverService = discoverService;
    }

    @GetMapping("/top-songs-by-genre={genre}")
    public JsonNode getTopSongsByGenre(@PathVariable String genre)  {
        return discoverService.fetchTopSongsByGenre(genre);
    }
}
