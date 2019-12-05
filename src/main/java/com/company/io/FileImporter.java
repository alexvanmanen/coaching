package com.company.io;

import com.company.model.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileImporter {

    private String readStringFromFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public Text readFromFile(String path) throws IOException {
        String text = readStringFromFile(path);
        return new Text(text);
    }
}
