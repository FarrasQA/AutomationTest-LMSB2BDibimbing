package api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig {

    private static final Properties props = loadProperties();

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static final String BASE_URL = get("BASE_URL");
    public static final String EMAIL = get("EMAIL");
    public static final String PASSWORD = get("PASSWORD");
    public static final String COMPANY_ID = get("COMPANY_ID");
    public static final String DEBUG = get("DEBUG");

    private static Properties loadProperties() {
        Properties prop = new Properties();
        String path = System.getProperty("user.dir") + "/src/test/resources/config/staging.properties";

        try (FileInputStream fis = new FileInputStream(path)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties: " + path, e);
        }

        return prop;
    }
}