package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class DiscoverServiceTest {

    @InjectMocks
    private DiscoverService discoverService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        discoverService = mock(DiscoverService.class);
    }

    @Test
    public void DiscoverService_FetchTopSongsByGenre_Success() {
        // Arrange
        String genre = "rock";
        JsonNode expectedTopSongs = Mockito.mock(JsonNode.class);

        when(discoverService.fetchTopSongsByGenre(genre)).thenReturn(expectedTopSongs);

        // Act
        JsonNode actualTopSongs = discoverService.fetchTopSongsByGenre(genre);

        // Assert
        Assertions.assertThat(actualTopSongs).isEqualTo(expectedTopSongs);
    }

    @Test
    public void DiscoverService_FetchTopSongsByGenre_ReturnsNull_WhenInvalidGenre() {

        // Arrange
        String invalidGenre = "invalid";

        when(discoverService.fetchTopSongsByGenre(invalidGenre)).thenReturn(null);

        // Act
        JsonNode result = discoverService.fetchTopSongsByGenre(invalidGenre);

        verify(discoverService).fetchTopSongsByGenre(invalidGenre);

        // Assert the result
        Assertions.assertThat(result).isNull();
    }
}
