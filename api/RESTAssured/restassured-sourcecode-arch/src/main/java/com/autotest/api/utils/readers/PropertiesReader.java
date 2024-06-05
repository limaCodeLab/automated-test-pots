package com.autotest.api.utils.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesReader {

    static Path root = FileSystems.getDefault().getPath("").toAbsolutePath();

    public String getProperties(String fileName, String keyName) {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(root + "/src/main/resources/" + fileName);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(keyName);
    }

}
