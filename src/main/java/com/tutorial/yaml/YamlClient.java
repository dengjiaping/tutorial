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
public class YamlClient {
    private static final Logger logger = LogManager.getLogger(YamlClient.class.getName());
    private Yaml yaml ;

    public static YamlClient getInstance(){
        return new YamlClient();
    }

    private YamlClient() {
        this.yaml = new Yaml();
    }

    public List<String> parserForList(String documents){
        return (List<String>) yaml.load(documents);
    }
    public String parserForString(String document){
        return (String) yaml.load(document);
    }

    public Map parserForMap(String document){
        return (Map) yaml.load(document);
    }

    /**
     * Yaml.load() accepts a String or an InputStream object. Yaml.load(InputStream stream)
     * detects the encoding by checking the BOM (byte order mark)
     * sequence at the beginning of the stream. If no BOM is present, the utf-8 encoding is assumed.
     * @param documents
     * @return
     */
    public Object parser(String documents){
        return yaml.load(documents);
    }

    public Iterable<Object> parserAll(String document){
        return yaml.loadAll(document);
    }
    public static void main(String[] args) throws FileNotFoundException {
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        YamlClient y = new YamlClient();
        logger.info("list is {}", y.parser(document));
        //logger.info("string is {}",y.parserForString(document));

        String mapper = "hello: 25"; // empty
        logger.info("mapper is {}",y.parserForMap(mapper));

        String path = ClassLoader.getSystemClassLoader().getResource("").getPath()+"yaml\\nestcollection.yaml";
        InputStream in = new FileInputStream(new File(path));
        logger.info("YAML is ",y.yaml.load(in));
    }


}
