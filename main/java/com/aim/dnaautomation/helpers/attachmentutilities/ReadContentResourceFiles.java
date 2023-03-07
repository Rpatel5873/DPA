package com.aim.dnaautomation.helpers.attachmentutilities;

import java.io.InputStream;

public class ReadContentResourceFiles {

    private ReadContentResourceFiles() {
        throw new IllegalStateException("Utility class");
    }
    public static InputStream readContentResourceFile (String path, String fileName) {
        InputStream is = ReadContentResourceFiles.class.getClassLoader().getResourceAsStream(path + fileName);

        if (is == null) {
            throw new RuntimeException(path+fileName);
        }
        return is;
    }
}
