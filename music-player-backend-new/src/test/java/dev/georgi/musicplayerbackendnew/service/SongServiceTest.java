package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SongServiceTest {

    @InjectMocks
    private SongService songService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        songService = mock(SongService.class);
    }

    @Test
    public void SongService_FetchSongDetails_Successfully() {
        // Arrange
        String validSongId = "valid";
        JsonNode expectedSongDetails = mock(JsonNode.class);

        when(songService.fetchSongDetails(validSongId)).thenReturn(expectedSongDetails);

        // Act
        JsonNode actualSongDetails = songService.fetchSongDetails(validSongId);

        // Assert
       Assertions.assertThat(actualSongDetails).isEqualTo(expectedSongDetails);
    }

    @Test
    public void SongService_FetchRelatedSongs_Successfully() {
        // Arrange
        String validSongId = "valid";
        JsonNode expectedRelatedSongs = mock(JsonNode.class);

        when(songService.fetchRelatedSongs(validSongId)).thenReturn(expectedRelatedSongs);

        // Act
        JsonNode actualRelatedSongs = songService.fetchRelatedSongs(validSongId);

        // Assert
        Assertions.assertThat(actualRelatedSongs).isEqualTo(expectedRelatedSongs);
    }

    @Test
    public void SongService_FetchSongsAroundYou_Successfully() {
        // Arrange
        String validCountryCode = "valid";
        JsonNode expectedSongsAroundYou = mock(JsonNode.class);

        when(songService.fetchSongsAroundYou(validCountryCode)).thenReturn(expectedSongsAroundYou);

        // Act
        JsonNode actualSongsAroundYou = songService.fetchSongsAroundYou(validCountryCode);

        // Assert
        Assertions.assertThat(actualSongsAroundYou).isEqualTo(expectedSongsAroundYou);
    }

    @Test
    public void SongService_FetchSongDetails_ThrowsExceptionWhenInvalidSongId() {
        // Arrange
        String invalidSongId = "invalid";
        String expectedErrorMessage = "Failed to fetch data";

        when(songService.fetchSongDetails(invalidSongId)).thenThrow(new RuntimeException(expectedErrorMessage));

        // Act and Assert
        Assertions.assertThatThrownBy(() -> songService.fetchSongDetails(invalidSongId)).hasMessage(expectedErrorMessage);
    }
    @Test
    public void SongService_FetchRelatedSongDetails_ThrowsExceptionWhenInvalidSongId() {
        // Arrange
        String invalidSongId = "invalid";
        String expectedErrorMessage = "Failed to fetch data";

        when(songService.fetchRelatedSongs(invalidSongId)).thenThrow(new RuntimeException(expectedErrorMessage));

        // Act and Assert
        Assertions.assertThatThrownBy(() -> songService.fetchRelatedSongs(invalidSongId)).hasMessage(expectedErrorMessage);
    }

    @Test
    public void SongService_FetchSongsAroundYou_ThrowsExceptionWhenInvalidCountryCode() {
        // Arrange
        String invalidCountryCode = "invalid";
        String expectedErrorMessage = "Failed to fetch data";

        when(songService.fetchSongsAroundYou(invalidCountryCode)).thenThrow(new RuntimeException(expectedErrorMessage));

        // Act and Assert
        Assertions.assertThatThrownBy(() -> songService.fetchSongsAroundYou(invalidCountryCode)).hasMessage(expectedErrorMessage);
    }
}