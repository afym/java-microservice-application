package com.afym;

import com.afym.application.RestResponse;
import com.afym.catalog.Services;
import com.afym.cpu.Arguments;
import com.afym.cpu.Executor;
import com.google.gson.Gson;
import static spark.Spark.get;

public class EntryPoint {
    public static void main(String[] args) {
        get("/", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            return gson.toJson(Services.list());
        });

        get("/v1/cpu/:cpu/:timeout", (request, response) -> {
            response.type("application/json");
            Gson gson = new Gson();
            RestResponse<String> restResponse = new RestResponse<String>();
            String cpu = request.params(":cpu");
            String timeout = request.params(":timeout");

            if (cpu != null && timeout != null) {
                Arguments arguments = new Arguments();
                arguments.setCpu(cpu);
                arguments.setTimeout(timeout);

                try {
                    Executor executor = new Executor(arguments);
                    String output = executor.run();
                    restResponse.setMessage(output);
                } catch (Exception e) {
                    restResponse.setMessage(e.getMessage());
                    restResponse.setError(true);
                }
            } else {
                restResponse.setError(true);
                restResponse.setMessage("The arguments are not correct");
            }

            return gson.toJson(restResponse);
        });
    }
}
