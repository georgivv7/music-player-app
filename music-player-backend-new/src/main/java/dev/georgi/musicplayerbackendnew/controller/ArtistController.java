package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ArtistController{
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists/{artistId}")
    public JsonNode getArtistDetails(@PathVariable String artistId){
        return artistService.fetchArtistData(artistId);
    }
}
