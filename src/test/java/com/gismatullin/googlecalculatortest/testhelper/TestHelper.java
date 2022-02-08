package com.gismatullin.googlecalculatortest.testhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestHelper {

    private static WebDriver driver;
    private static final int TIMEOUT = 5;
    private static final boolean HEADLESS = true;

    private TestHelper() {}

    private static final String ROOT_PATH = new File("").getAbsolutePath();

    public static void prepareDriver() {
        ChromeOptions options = new ChromeOptions();
        if (HEADLESS) {
            options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties loadProperties(String path) {
        try (InputStream input = new FileInputStream(ROOT_PATH + "/" + path)) {
            Properties props = new Properties();
            props.load(input);
            return props;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement getElement(Properties uiMapProps, String key) {
        String selector = uiMapProps.getProperty(key);
        By by;
        if (selector.startsWith("//")) {
            by =  By.xpath(selector);
        } else {
            by = By.cssSelector(selector);
        }
        return getDriver().findElement(by);
    }
}
