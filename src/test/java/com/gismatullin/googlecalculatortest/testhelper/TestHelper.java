package com.gismatullin.googlecalculatortest.testhelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestHelper {

    private static final String PROPS_PATH = "./src/test/resources/config.properties";
    private static WebDriver driver;
    public static int timeout = 10; // default value
    public static boolean headless = false; // default value

    static {
        try (InputStream input = new FileInputStream(PROPS_PATH)) {
            Properties props = new Properties();
            props.load(input);
            headless = Boolean.valueOf(props.getProperty("headless"));
            timeout = Integer.valueOf(props.getProperty("timeout"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private TestHelper() {}

    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        URL url;
        try {
            url = new URL("http://127.0.01:4444/wd/hub");
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.setProperty("io.qameta.allure.CommandLine", "/opt/allure-commandline/allure-2.14.0/bin/allure");
        driver = new RemoteWebDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
    }

    // public static void getReady(String path) {
    //     ChromeOptions options = new ChromeOptions();
    //     // options.addArguments("--headless");
    //     driver = new ChromeDriver(options);
    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    //     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
    // }

    public static void clean() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
}
