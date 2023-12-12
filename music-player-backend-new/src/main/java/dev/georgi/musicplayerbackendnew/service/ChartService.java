package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.georgi.musicplayerbackendnew.dto.songDTOs.SongDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@Slf4j
public class ChartService extends ShazamAPIService{

    public ChartService(RestClient restClient) {
        super(restClient);
    }
    public List<SongDto> fetchTopCharts() throws JsonProcessingException {
        List<SongDto> topCharts = deserializeToDTO();
        log.info("Successfully fetched Top charts: {}", topCharts.size());
        return topCharts;
    }

    private final ObjectMapper mapper = new ObjectMapper();
    private List<SongDto> deserializeToDTO() throws JsonProcessingException {
        String apiUri = "/v1/charts/world";
        JsonNode jsonNode = fetchDataFromApi(apiUri);
        return mapper.readValue(jsonNode.toString(), new TypeReference<>() {
        });
    }
}
