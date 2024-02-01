package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver() {

    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    /*ChromeOptions options= new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriver driver= new ChromeDriver(options);*/
                    driver = new ChromeDriver();

                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge" -> driver = new EdgeDriver();
            }

        }

        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
