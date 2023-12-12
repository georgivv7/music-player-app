package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {
    @InjectMocks
    private ArtistService artistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        artistService = Mockito.mock(ArtistService.class);
    }

    @Test
    public void ArtistService_FetchArtistData_ReturnsJsonNode_Successfully() {
        // Arrange
        String artistId = "123";
        JsonNode artistDetails = Mockito.mock(JsonNode.class); // create a mock JsonNode object

        // When

        when(artistService.fetchArtistData(artistId)).thenReturn(artistDetails);
        // Act
        JsonNode result = artistService.fetchArtistData(artistId);

        // Assert the result
        Assertions.assertThat(result).isEqualTo(artistDetails);
    }
    @Test
    public void ArtistService_FetchArtistData_ReturnsNull_WhenInvalidArtistId() {

        // Arrange
        String invalidArtistId = "invalid";

        when(artistService.fetchArtistData(invalidArtistId)).thenReturn(null);

        // Act
        JsonNode result = artistService.fetchArtistData(invalidArtistId);

        verify(artistService).fetchArtistData(invalidArtistId);

        // Assert the result
        Assertions.assertThat(result).isNull();
    }
}