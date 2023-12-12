package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TentacledEditorialArtwork {
        private Artwork bannerUber;
        private Artwork centeredFullscreenBackground;
        private Artwork originalFlowcaseBrick;
        private Artwork storeFlowcase;
        private Artwork subscriptionHero;
        private Artwork vipSquare;
}
