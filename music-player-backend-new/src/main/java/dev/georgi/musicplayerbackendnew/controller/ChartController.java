package dev.georgi.musicplayerbackendnew.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.georgi.musicplayerbackendnew.dto.songDTOs.SongDto;
import dev.georgi.musicplayerbackendnew.service.ChartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ChartController {
    private final ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/top-charts")
    public List<SongDto> getTopCharts() throws JsonProcessingException {
        return chartService.fetchTopCharts();
    }
}
