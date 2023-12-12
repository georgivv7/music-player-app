package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class SongService extends ShazamAPIService {

    public SongService(RestClient restClient) {
        super(restClient);
    }

    public JsonNode fetchSongDetails(String songId)  {
        String apiUri = "/v1/tracks/details?track_id=" + songId;
        JsonNode songDetails = fetchDataFromApi(apiUri);
        log.info("Successfully fetched song details. Count: {}", songDetails.size());
        return songDetails;
    }

    public JsonNode fetchRelatedSongs(String songId)  {
        String apiUri = "/v1/tracks/related?track_id=" + songId;
        JsonNode relatedSongs = fetchDataFromApi(apiUri);
        log.info("Successfully fetched related songs: {}", relatedSongs.size());
        return relatedSongs;
    }

    public JsonNode fetchSongsAroundYou(String countryCode)  {
        String apiUri = "/v1/charts/country?country_code=" + countryCode;
        JsonNode songsAroundYou = fetchDataFromApi(apiUri);
        log.info("Successfully fetched songs around you: {}", songsAroundYou.size());
        return songsAroundYou;
    }
}
