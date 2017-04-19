package com.afym;

import com.afym.application.GetCountry;
import com.afym.application.RestResponse;
import com.afym.catalog.Services;
import com.afym.model.Country;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class EntryPoint {
    public static void main(String[] args){
        get("/", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            return gson.toJson(Services.list());
        });

        get("/v1/countries", (request, response) -> {
            System.out.print("::::::::::::::: inside :::::::::::::::");
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<Country> restResponse = new RestResponse<Country>();

            try {
                GetCountry connector = new GetCountry();
                restResponse.setData(connector.getAll());
            } catch (Exception exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
                restResponse.setData(null);
            }

            return gson.toJson(restResponse);
        });

        get("/v1/countries/:countryId/cities",(request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<Country> restResponse = new RestResponse<Country>();
            List<Country> countries = new ArrayList<Country>();

            try {
                int countryId = Integer.parseInt(request.params(":countryId"));
                GetCountry getCountry = new GetCountry();
                countries.add(getCountry.getCities(countryId));
                restResponse.setData(countries);
            } catch (Exception exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
                restResponse.setData(null);
            }

            return gson.toJson(restResponse);
        });

        get("/v1/countries/:countryId/populations",(request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<Country> restResponse = new RestResponse<Country>();
            List<Country> countries = new ArrayList<Country>();

            try {
                int countryId = Integer.parseInt(request.params(":countryId"));
                GetCountry getCountry = new GetCountry();
                countries.add(getCountry.getPopulations(countryId));
                restResponse.setData(countries);
            } catch (Exception exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
                restResponse.setData(null);
            }

            return gson.toJson(restResponse);
        });
    }
}