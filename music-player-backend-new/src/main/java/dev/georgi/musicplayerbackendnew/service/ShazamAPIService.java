package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class ShazamAPIService {

    public final RestClient restClient;

    @Value("${rapidapi.key}")
    private String shazamAPIKey;

    @Value("${rapidapi.host}")
    private String shazamHost;

    @Value("${rapidapi.shazam.url}")
    private String shazamAPIBaseUrl;

    public ShazamAPIService(RestClient restClient) {
        this.restClient = restClient;
    }

    public JsonNode fetchDataFromApi(String apiUri) {

        return restClient.get()
                .uri(shazamAPIBaseUrl + apiUri)
                .accept(MediaType.APPLICATION_JSON)
                .header("X-RapidAPI-KEY", shazamAPIKey)
                .header("X-RapidAPI-Host", shazamHost)
                .retrieve()
                .onStatus(statusCode -> statusCode == HttpStatusCode.valueOf(404), (request, response) -> {
                    throw new RuntimeException("Failed to fetch data");
                })
                .body(JsonNode.class);
    }
}
