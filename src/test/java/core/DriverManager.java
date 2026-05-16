package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initializeDriver(String browser) {

        if (driver.get() != null) {
            System.out.println("Using existing driver session");
            return;
        }

        if (browser == null || browser.isBlank()) {
            browser = "chrome";
        }

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome" -> {

                boolean isCI = "true".equalsIgnoreCase(System.getenv("GITHUB_ACTIONS"));

                ChromeOptions options = new ChromeOptions();

                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-extensions");

                if (isCI) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                }

                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);
            }

            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }

            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                webDriver = new org.openqa.selenium.edge.EdgeDriver();
            }

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }

        driver.set(webDriver);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        System.out.println("Driver initialized successfully");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            try {
                driver.get().quit();
            } finally {
                driver.remove();
                System.out.println("Driver removed from ThreadLocal");
            }
        }
    }
}