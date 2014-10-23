package com.tutorial.yaml;

import com.tutorial.utils.FileHelper;
import com.tutorial.yaml.beans.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class YamlBean {
    private static final Logger logger = LogManager.getLogger(YamlBean.class.getName());

    public static void main(String[] args) throws IOException {
        String document = FileHelper.read("yaml/person.yaml");

        Person p = (Person) YamlClient.getInstance(Person.class).parser(document);
        logger.info("person: {}", p);
    }
}
