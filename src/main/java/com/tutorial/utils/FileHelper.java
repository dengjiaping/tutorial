package com.tutorial.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    private static final Logger logger = LogManager.getLogger(FileHelper.class.getName());

    private FileHelper(){}

    public static String read(String path) throws IOException {

        String absPath = ClassLoader.getSystemClassLoader().getResource("").getPath()+path;
        return FileUtils.readFileToString(new File(absPath));
    }
}
