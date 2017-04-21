package com.afym.catalog;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public static List<String> list() {
        List<String> services = new ArrayList<String>();
        services.add("/");
        services.add("/v1/track/write");
        services.add("/v1/track/read/:base64KeyFile");
        return  services;
    }
}
