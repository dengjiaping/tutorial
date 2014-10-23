package com.tutorial.yaml;

import com.tutorial.utils.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class YamlMap {
    private static final Logger logger = LogManager.getLogger(YamlMap.class.getName());

    public static void main(String[] args) throws IOException {
        String document = FileHelper.read("yaml/nestcollection.yaml");
        logger.info(YamlClient.getInstance().parser(document));
        logger.info(YamlClient.getInstance().parserForMap(document));
    }
}
