package com.afym;

import com.afym.application.Reader;
import com.afym.application.Writer;
import com.afym.util.Decoder;
import com.google.gson.Gson;
import com.afym.catalog.Services;
import com.afym.application.RestResponse;

import static spark.Spark.*;

public class EntryPoint {
    public static void main(String [] args){
        get("/", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            return gson.toJson(Services.list());
        });

        post("/v1/track/write", (request, response) -> {
            response.type("application/json");
            String keyFileB64 = request.queryParams("base64keyFile");
            String contentFileB64 = request.queryParams("base64contentFile");

            Gson gson = new Gson();
            RestResponse<String> restResponse = new RestResponse<String>();

            if (keyFileB64 != null && contentFileB64 != null) {
                try {
                    String keyFile = Decoder.getString(keyFileB64);
                    Writer writer = new Writer();
                    writer.write(keyFile, Decoder.getString(contentFileB64));

                    if (!writer.getState()) {
                        throw new Exception("Could not write the file");
                    }

                    restResponse.setMessage(keyFile + " was tracked correctly!");
                } catch (Exception exception) {
                    restResponse.setMessage(exception.getMessage());
                    restResponse.setError(true);
                }
            } else {
                restResponse.setMessage("params are not readable");
            }

            return gson.toJson(restResponse);
        });

        get("/v1/track/read/:base64KeyFile",(request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<String> restResponse = new RestResponse<String>();

            try {
                String keyFile = Decoder.getString(request.params(":base64KeyFile"));
                Reader reader = new Reader();
                String content = reader.read(keyFile);

                if (!reader.getState()) {
                    throw new Exception("Could not read the file");
                }

                restResponse.setMessage("content is : " + content);
            } catch (Exception exception) {
                restResponse.setMessage(exception.getMessage());
                restResponse.setError(true);
            }

            return gson.toJson(restResponse);
        });
    }
}
