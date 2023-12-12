package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class DiscoverService extends ShazamAPIService{

    public DiscoverService(RestClient restClient) {
        super(restClient);
    }

    public JsonNode fetchTopSongsByGenre(String genre) {
        String apiUri = "/v1/charts/genre-world?genre_code=" + genre;
        JsonNode topSongs = fetchDataFromApi(apiUri);
        log.info("Successfully fetched top songs by genre: {}", topSongs.toString().length());
        return topSongs;
    }
}
