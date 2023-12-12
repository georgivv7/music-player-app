package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.DiscoverService;
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

@WebMvcTest(DiscoverController.class)
class DiscoverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiscoverService discoverService;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void DiscoverController_FetchTopSongsByGenre() throws Exception {
        // Given
        String genre = "POP";
        JsonNode songsData = mock(JsonNode.class);// create your expected artist data here

        given(discoverService.fetchTopSongsByGenre(genre)).willReturn(songsData);

        // When and Then
        mockMvc.perform(get("/api/v1/top-songs-by-genre={genre}", genre))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(discoverService).fetchTopSongsByGenre(genre);
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void DiscoverController_FetchTopSongsByGenre_NotFound() throws Exception {
        // Given
        String genre = "POP";

        given(discoverService.fetchTopSongsByGenre(genre)).willThrow(new MockitoException("Top songs not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/top-songs-by-genre={genre}", genre))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(discoverService).fetchTopSongsByGenre(genre);
    }
}