package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static Properties config;

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() {

        try {

            config = new Properties();

            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config/staging.properties");

            if (input == null) {
                throw new RuntimeException("staging.properties NOT FOUND");
            }

            config.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        DriverManager.initializeDriver(browser);

        driver = DriverManager.getDriver();

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));

        driver.get(config.getProperty("baseUrl"));

        System.out.println("OPEN URL: " + config.getProperty("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverManager.quitDriver();
    }
}
