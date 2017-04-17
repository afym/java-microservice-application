package com.afym;

import com.afym.application.GetCountry;
import com.afym.application.RestResponse;
import com.afym.catalog.Services;
import com.afym.model.Country;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.*;

public class EntryPoint {
    public static void main(String[] args){
        get("/", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            return gson.toJson(Services.list());
        });

        get("/v1/country", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<String> restResponse = new RestResponse<String>();
            List<Country> countries;

            try {
                GetCountry connector = new GetCountry();
                countries = connector.getAll("", "");
            } catch (SQLException exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
                countries = null;
            } catch (ClassNotFoundException exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
                countries = null;
            }

            return gson.toJson(countries);
        });
    }
}