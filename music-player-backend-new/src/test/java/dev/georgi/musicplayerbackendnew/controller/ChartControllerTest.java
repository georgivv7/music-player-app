package dev.georgi.musicplayerbackendnew.controller;

import dev.georgi.musicplayerbackendnew.dto.songDTOs.SongDto;
import dev.georgi.musicplayerbackendnew.service.ChartService;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChartController.class)
class ChartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChartService chartService;

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void ChartController_FetchTopCharts() throws Exception {
        // Given
        List<SongDto> chartsData = List.of();

        given(chartService.fetchTopCharts()).willReturn(chartsData);

        // When and Then
        mockMvc.perform(get("/api/v1/top-charts"))
                .andExpect(status().isOk());

        // Verify that the service was called
        verify(chartService).fetchTopCharts();
    }
    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void ChartController_FetchTopCharts_NotFound() throws Exception {

        // Given
        given(chartService.fetchTopCharts()).willThrow(new MockitoException("Charts data not found!"));

        // When and Then
        mockMvc.perform(get("/api/v1/top-charts"))
                .andExpect(status().isInternalServerError());

        // Verify that the service was called
        verify(chartService).fetchTopCharts();
    }
}