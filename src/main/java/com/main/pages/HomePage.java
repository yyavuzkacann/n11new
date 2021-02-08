package com.main.pages;

import com.main.base.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class HomePage extends BaseMethods {

    private static By CLOSE_GDPR = By.xpath("(//span[@class='closeBtn'])[1]");
    private static By CLOSE_NOTIFICATION = By.xpath("//div[@class='dn-slide-buttons horizontal']//button[text()='Daha Sonra']");
    private static By CLOSE_COUPON = By.xpath("//span[@class='seg-popup-close']");
    private static By LOGIN_BUTTON = By.xpath("//a[contains(text(),'Giriş Yap')]");
    private static By LBL_USERNAME = By.xpath("//*[@class='menuLink user']");
    private static By INP_SEARCH = By.xpath("//input[@id='searchData']");
    private static By BTN_SEARCH = By.xpath("//span[@class='icon iconSearch']");
    private static By BTN_SECOND = By.xpath("//div[@class='pagination']//a[2]");
    private static By BTN_PRODUCT = By.xpath("//div[@id='view']//li[3]");

    public HomePage pageLoadCheck() {
        logInfo(getTitle());
        if (getTitle().contains("Hayat Sana Gelir"))
            logInfo("Page loaded successfully.");
        else
            logFatal("Page couldn't load");
        return this;
    }

    public HomePage closeGDPRText() {
        if (isElementPresent(CLOSE_GDPR)) {
            logInfo("GDPR text is closed");
            clickElement(CLOSE_GDPR);
        }
        return this;
    }

    public HomePage closeCoupon() {
        if (isElementPresent(CLOSE_COUPON)) {
            logInfo("Coupon panel is closed");
            clickElement(CLOSE_COUPON);
        }
        return this;
    }

    public HomePage closeNotificationPanel() {
        if (isElementPresent(CLOSE_NOTIFICATION)) {
            logInfo("Notification panel is closed");
            clickElement(CLOSE_NOTIFICATION);
        }
        return this;
    }

    public HomePage clickLogin() {
        logInfo("Login button is clicked");
        if (isElementPresent(LOGIN_BUTTON))
            clickElement(LOGIN_BUTTON);
        else
            logFatal("Login button couldn't find");
        return this;
    }

    public HomePage loginCheck(String username) {
        logInfo("Check if login successful");
        if (isElementPresent(LBL_USERNAME) && getText(LBL_USERNAME).contains(username))
            logInfo("Login succeed");
        else
            logFatal("Login couldn't succeed");
        return this;
    }

    public HomePage searchProduct(String product) {
        logInfo("Product is searched");
        if (isElementPresent(INP_SEARCH)) {
            clickElement(INP_SEARCH);
            sendKeys(INP_SEARCH, product);
            clickElement(BTN_SEARCH);
        } else
            logFatal("Search input couldn't find");
        return this;
    }

    public HomePage searchCheck(String product) {
        logInfo("Check if search succeed");
        By LBL_SEARCH = By.xpath("//div[@id='breadCrumb']//span[contains(text(),'" + product + "')]");
        if (isElementPresent(LBL_SEARCH))
            logInfo("Search succeed.");
        else
            logFatal("Search couldn't succeed.");
        return this;
    }

    public HomePage clickSecondPage() {
        if (isElementPresent(BTN_SECOND)) {
            logInfo("Second page is clicked");
            scroll(BTN_SECOND);
            clickElement(BTN_SECOND);
        } else
            logFatal("Second page button couldn't find");
        return this;
    }

    public HomePage checkSecondPageLoad() {
        if (getUrl().contains("pg=2"))
            logInfo("Second page loaded successfully");
        else
            logFatal("Second page couldn't load");
        return this;
    }

    public HomePage clickThirdProduct() throws InterruptedException {
        logInfo("Third product is clicked");
        if (isElementPresent(BTN_PRODUCT)) {
            scroll(BTN_PRODUCT);
            sleep(3000);
            findElement(BTN_PRODUCT).findElement(By.tagName("a")).click();
        } else
            logFatal("Product couldn't find on the page");
        return this;
    }
}
