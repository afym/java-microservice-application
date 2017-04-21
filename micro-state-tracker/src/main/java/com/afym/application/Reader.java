package com.afym.application;

import com.afym.tracker.TrackerReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader extends BaseVolumeIO implements TrackerReader{
    @Override
    public String read(String keyFile) {
        String path = this.volumePersist.getFullFilePath(keyFile);
        String fileContent = "content not found";

        try {
            this.state = true;
            fileContent = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }
}
