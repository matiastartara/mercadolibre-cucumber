package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Reporter;

import java.net.MalformedURLException;

public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver get() throws MalformedURLException {

        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        String headlessMode = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("headless");

        if (driver.get() == null) {

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (Boolean.valueOf(headlessMode)) {
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                    }

                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (Boolean.valueOf(headlessMode)) {
                        edgeOptions.addArguments("--headless=new");
                        edgeOptions.addArguments("--start-maximized");
                        edgeOptions.addArguments("--disable-gpu");
                        edgeOptions.addArguments("--no-sandbox");
                    }

                    driver.set(new EdgeDriver(edgeOptions));
                    break;

                default:
                    throw new IllegalArgumentException("Browser [" + browser + "] is NOT supported");
            }

        }

        return driver.get();
    }

    public static void quit() {
        driver.get().quit();
        driver.remove();
    }

}
