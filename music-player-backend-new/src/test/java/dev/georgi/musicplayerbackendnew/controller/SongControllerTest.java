package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.SongService;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongService songService;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void SongController_FetchSongDetails() throws Exception {
        // Given
        String songId = "123";
        JsonNode songsData = mock(JsonNode.class);// create your expected artist data here

        given(songService.fetchSongDetails(songId)).willReturn(songsData);

        // When and Then
        mockMvc.perform(get("/api/v1/songs/{songId}", songId))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(songService).fetchSongDetails(songId);
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void SongController_FetchRelatedSongDetails() throws Exception {
        // Given
        String songId = "123";
        JsonNode songsData = mock(JsonNode.class);// create your expected artist data here

        given(songService.fetchRelatedSongs(songId)).willReturn(songsData);

        // When and Then
        mockMvc.perform(get("/api/v1/songs/related/{songId}", songId))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(songService).fetchRelatedSongs(songId);
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void SongController_FetchSongDetailsAroundYou() throws Exception {
        // Given
        String countryCode = "BG";
        JsonNode songsData = mock(JsonNode.class);// create your expected artist data here

        given(songService.fetchSongsAroundYou(countryCode)).willReturn(songsData);

        // When and Then
        mockMvc.perform(get("/api/v1/around-you/{countryCode}", countryCode))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(songService).fetchSongsAroundYou(countryCode);
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void SongController_FetchSongDetails_NotFound() throws Exception {
        // Given
        String songId = "123";

        given(songService.fetchSongDetails(songId)).willThrow(new MockitoException("Song details data not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/songs/{songId}", songId))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(songService).fetchSongDetails(songId);
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void SongController_FetchRelatedSongDetails_NotFound() throws Exception {
        // Given
        String songId = "123";

        given(songService.fetchRelatedSongs(songId)).willThrow(new MockitoException("Related song details not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/songs/related/{songId}", songId))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(songService).fetchRelatedSongs(songId);
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void SongController_FetchSongDetailsAroundYou_NotFound() throws Exception {
        // Given
        String countryCode = "BG";

        given(songService.fetchSongsAroundYou(countryCode)).willThrow(new MockitoException("Songs around you data not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/around-you/{countryCode}", countryCode))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(songService).fetchSongsAroundYou(countryCode);
    }
}