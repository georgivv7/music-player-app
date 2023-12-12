package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class ArtistService extends ShazamAPIService{

    public ArtistService(RestClient restClient) {
        super(restClient);
    }

    public JsonNode fetchArtistData(String artistId)  {
        String apiUri = "/v2/artists/details?artist_id=" + artistId;
        JsonNode artistDetails = fetchDataFromApi(apiUri);
        log.info("Successfully fetched artist data for artistId: {}", artistId);
        return artistDetails;
    }
}
