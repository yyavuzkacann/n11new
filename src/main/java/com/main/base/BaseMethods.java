package com.main.base;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.main.Constants.URL;

public class BaseMethods {
    public static WebDriver driver = setDriver();
    static final Logger logger = LoggerFactory.getLogger(BaseMethods.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logFatal(String message) {
        logger.error(message);
        Assert.fail(message);
    }

    @BeforeClass
    public static WebDriver setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        element.click();
    }

    public String getText(By by) {
        WebElement element = driver.findElement(by);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return element.getText();
    }

    protected boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public void sendKeys(By locator, String message) {
        WebElement element = driver.findElement(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        element.sendKeys(message);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void scroll(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator));
        actions.build().perform();
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void mouseHover(By by) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).build().perform();
    }

    public static void close() {
        driver.close();
    }
}
