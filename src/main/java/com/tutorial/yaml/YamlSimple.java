package com.tutorial.yaml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * convert YAML document to a JAVA object
 */
public class YamlSimple {
    private static final Logger logger = LogManager.getLogger(YamlSimple.class.getName());
    private Yaml yaml ;

    public YamlSimple() {
        this.yaml = new Yaml();
    }

    public List<String> parser(String documents){
        return (List<String>) yaml.load(documents);
    }
    public String parserForString(String document){
        return (String) yaml.load(document);
    }

    public Map parserForMap(String document){
        return (Map) yaml.load(document);
    }
    public static void main(String[] args) throws FileNotFoundException {
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        YamlSimple y = new YamlSimple();
        logger.info("list is {}", y.parser(document));
        //logger.info("string is {}",y.parserForString(document));

        String mapper = "hello: 25"; // empty
        logger.info("mapper is {}",y.parserForMap(mapper));

        String path = ClassLoader.getSystemClassLoader().getResource("").getPath()+"yaml/nestcollection.yaml";
        InputStream in = new FileInputStream(new File(path));
        logger.info("yaml is ",y.yaml.load(in));
    }
}
