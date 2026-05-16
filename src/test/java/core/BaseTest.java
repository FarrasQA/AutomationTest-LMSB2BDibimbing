package core;

import org.testng.annotations.*;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static Properties config;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() {

        try {
            config = new Properties();

            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties NOT FOUND");
            }

            config.load(input);

            System.out.println("SUCCESS LOAD CONFIG");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {

        DriverManager.initializeDriver(browser);

        DriverManager.getDriver().manage().window().maximize();

        String baseUrl = config.getProperty("base.url");

        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new RuntimeException("base.url kosong di config.properties");
        }

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        DriverManager.getDriver().get(baseUrl);

        System.out.println("OPEN URL: " + baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
    }

    public static Properties getConfig() {
        return config;
    }
}