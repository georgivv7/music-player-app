package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class SearchService extends ShazamAPIService{

    public SearchService(RestClient restClient) {
        super(restClient);
    }

    public JsonNode searchSongsArtists(String searchTerm) {
        String apiUri = "/v1/search/multi?search_type=SONGS_ARTISTS&query=" + searchTerm;
        JsonNode searchResults = fetchDataFromApi(apiUri);
        log.info("Successfully fetched search results. Count: {}", searchResults.size());
        return searchResults;
    }
}
