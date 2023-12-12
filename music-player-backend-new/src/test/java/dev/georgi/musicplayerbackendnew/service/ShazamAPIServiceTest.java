package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ShazamAPIServiceTest {
    @InjectMocks
    private ShazamAPIService shazamAPIService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        shazamAPIService = mock(ShazamAPIService.class);
    }

    @Test
    public void ShazamAPIService_FetchDataFromApi_Success() {

        // Arrange
        when(shazamAPIService.fetchDataFromApi(any())).thenReturn(mock(JsonNode.class));

        // Act
        JsonNode result = shazamAPIService.fetchDataFromApi("/testApiUrl");

        verify(shazamAPIService).fetchDataFromApi(any());

        // Assert
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    public void ShazamAPIService_FetchDataFromApi_ReturnsNull_WhenInvalidUrl() {

        // Arrange
        String apiUrl = "invalid";

        when(shazamAPIService.fetchDataFromApi(apiUrl)).thenReturn(null);

        // Act
        JsonNode result = shazamAPIService.fetchDataFromApi(apiUrl);

        verify(shazamAPIService).fetchDataFromApi(apiUrl);

        // Assert
        Assertions.assertThat(result).isNull();
    }
}

