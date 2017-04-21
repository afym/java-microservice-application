package com.afym.config;

import java.util.Map;

public class VolumePersist {
    private static String KEY_PATH = "CLUSTER_VOLUME_PATH";
    private String path;

    public VolumePersist(){
        this.setPath();
    }

    public String getPath() {
        return path;
    }

    public String getFullFilePath(String keyFile) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.path)
                .append(keyFile);

        return builder.toString();
    }

    private void setPath() {
        Map<String, String> environments = System.getenv();

        if (environments.get(KEY_PATH) != null) {
            this.path = environments.get(KEY_PATH);
        } else {
            this.path = "/tmp";
        }
    }
}
