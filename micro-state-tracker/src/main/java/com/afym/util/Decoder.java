package com.afym.util;

import java.util.Base64;

public class Decoder {
    public static String getString(String base64) {
        return new String(Base64.getDecoder().decode(base64));
    }
}
