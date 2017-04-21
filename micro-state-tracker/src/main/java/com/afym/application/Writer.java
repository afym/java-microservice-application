package com.afym.application;

import com.afym.tracker.TrackerWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Writer extends BaseVolumeIO implements TrackerWriter{

    @Override
    public void write(String keyFile, String content) {
        String path = this.volumePersist.getFullFilePath(keyFile);

        try {
            FileOutputStream file = new FileOutputStream(path);
            OutputStreamWriter output = new OutputStreamWriter(file);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(content);
            writer.close();
            this.state = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
