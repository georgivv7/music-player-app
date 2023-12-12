package dev.georgi.musicplayerbackendnew.dto.artistDTOs;

import java.io.IOException;

public enum AudioLocale {
    EN_US, ZU;

    public String toValue() {
        switch (this) {
            case EN_US: return "en-US";
            case ZU: return "zu";
        }
        return null;
    }

    public static AudioLocale forValue(String value) throws IOException {
        if (value.equals("en-US")) return EN_US;
        if (value.equals("zu")) return ZU;
        throw new IOException("Cannot deserialize AudioLocale");
    }
}
