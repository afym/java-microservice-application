package com.afym.catalog;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public static List<String> list() {
        List<String> services = new ArrayList<String>();
        services.add("/");
        services.add("/v1/countries");
        services.add("/v1/countries/:countryId/cities");
        services.add("/v1/countries/:countryId/populations");
        return  services;
    }
}
