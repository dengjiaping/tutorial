package com.tutorial.yaml;

import com.tutorial.utils.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class YamlMultiple {
    private static final Logger logger = LogManager.getLogger(YamlMultiple.class.getName());

    public static void main(String[] args) throws IOException {
        String document = FileHelper.read("yaml/multipledocument.yaml");
        logger.info(YamlClient.getInstance().parserAll(document));
        for (Object o : YamlClient.getInstance().parserAll(document)) {
            logger.info("object is : {} \n", o);
        }
    }
}
