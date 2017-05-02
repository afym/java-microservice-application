package com.afym.cpu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executor implements Executable{
    private Arguments arguments;

    public Executor(Arguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public String run() throws InterruptedException, IOException {

        Process process = Runtime.getRuntime().exec(StressCommand.build(this.arguments));
        process.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        StringBuffer output = new StringBuffer();

        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

        return output.toString();
    }
}
