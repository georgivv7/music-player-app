package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.service.SearchService;
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

@WebMvcTest(SearchController.class)
class SearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void SearchController_SearchSongArtist() throws Exception {
        // Given
        String searchTerm = "term";
        JsonNode searchData = mock(JsonNode.class);// create your expected artist data here

        given(searchService.searchSongsArtists(searchTerm)).willReturn(searchData);

        // When and Then
        mockMvc.perform(get("/api/v1/search/{searchTerm}", searchTerm))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(searchService).searchSongsArtists(searchTerm);
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void SearchController_SearchSongArtist_NotFound() throws Exception {
        // Given
        String searchTerm = "term";

        given(searchService.searchSongsArtists(searchTerm)).willThrow(new MockitoException("Search data not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/search/{searchTerm}", searchTerm))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(searchService).searchSongsArtists(searchTerm);
    }
}