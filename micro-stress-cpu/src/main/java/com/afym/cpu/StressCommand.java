package com.afym.cpu;

public class StressCommand {
    public static String build(Arguments arguments) {
        StringBuilder builder = new StringBuilder();
        builder.append("stress ")
                .append("--cpu ").append(arguments.getCpu()).append(" ")
                .append("--timeout ").append(arguments.getTimeout()).append(" ");
        return builder.toString();
    }
}
