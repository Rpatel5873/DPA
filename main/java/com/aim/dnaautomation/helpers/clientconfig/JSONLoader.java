package com.aim.dnaautomation.helpers.clientconfig;
import com.aim.automation.helpers.ReadContentResourceFiles;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;

public class JSONLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONLoader.class);
public <T> T readDtoFromFile(String filePath, Class<T> tClass) {
        InputStream inputStream = new ReadContentResourceFiles().readContentResourceFile(filePath);

        T result = null;
        try {
            result = new ObjectMapper().readValue(inputStream, tClass);
        } catch (IOException e) {
            LOGGER.error("Could not load JSON file data from file {}", filePath, e);
        }
        return result;
    }
}
