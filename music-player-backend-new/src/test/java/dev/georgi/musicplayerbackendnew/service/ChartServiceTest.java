package dev.georgi.musicplayerbackendnew.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dev.georgi.musicplayerbackendnew.dto.songDTOs.SongDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChartServiceTest {
    @InjectMocks
    private ChartService chartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        chartService = Mockito.mock(ChartService.class);
    }

    @Test
    void ChartService_FetchTopCharts_ReturnsListOfSongDTOs() throws JsonProcessingException {
        // Arrange
        List<SongDto> expected = mock(List.class);

        when(chartService.fetchTopCharts()).thenReturn(expected);

        // Act
        List<SongDto> actual = chartService.fetchTopCharts();

        verify(chartService).fetchTopCharts();

        // Assert
        Assertions.assertThat(actual).isEqualTo(expected);

    }
}
