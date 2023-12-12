package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import java.io.IOException;

public enum AudioTrait {
    ATMOS, LOSSLESS, LOSSY_STEREO, SPATIAL;

    public String toValue() {
        switch (this) {
            case ATMOS: return "atmos";
            case LOSSLESS: return "lossless";
            case LOSSY_STEREO: return "lossy-stereo";
            case SPATIAL: return "spatial";
        }
        return null;
    }

    public static AudioTrait forValue(String value) throws IOException {
        if (value.equals("atmos")) return ATMOS;
        if (value.equals("lossless")) return LOSSLESS;
        if (value.equals("lossy-stereo")) return LOSSY_STEREO;
        if (value.equals("spatial")) return SPATIAL;
        throw new IOException("Cannot deserialize AudioTrait");
    }
}
