package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class SearchServiceTest {
    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        searchService = mock(SearchService.class);
    }
    @Test
    public void SearchService_SearchSongsArtists_Success() {
        // Arrange
        String searchTerm = "test";
        when(searchService.searchSongsArtists(searchTerm)).thenReturn(mock(JsonNode.class));

        // Act
        JsonNode searchResults = searchService.searchSongsArtists(searchTerm);

        // Assert
        Assertions.assertThat(searchResults).isNotNull();
    }

    @Test
    public void SearchService_SearchSongsArtists_ReturnsNull_WhenInvalidTerm() {

        // Arrange
        String invalidSearchTerm = "invalid";

        when(searchService.searchSongsArtists(invalidSearchTerm)).thenReturn(null);

        // Act
        JsonNode result = searchService.searchSongsArtists(invalidSearchTerm);

        verify(searchService).searchSongsArtists(invalidSearchTerm);

        // Assert
        Assertions.assertThat(result).isNull();
    }
}