package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.ArtistService;
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

@WebMvcTest(ArtistController.class)
class ArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArtistService artistService;


    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void ArtistController_FetchArtistDetails() throws Exception {
        // Given
        String artistId = "123";
        JsonNode artistData = mock(JsonNode.class);// create your expected artist data here

        given(artistService.fetchArtistData(artistId)).willReturn(artistData);

        // When and Then
        mockMvc.perform(get("/api/v1/artists/{artistId}", artistId))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(artistService).fetchArtistData(artistId);
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void ArtistController_FetchArtistDetails_NotFound() throws Exception {
        // Given
        String artistId = "123";

        given(artistService.fetchArtistData(artistId)).willThrow(new MockitoException("Artist details not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/artists/{artistId}", artistId))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(artistService).fetchArtistData(artistId);
    }

}