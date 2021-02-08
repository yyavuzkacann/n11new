package com.main.pages;

import com.main.base.BaseMethods;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class ProductPage extends BaseMethods {
    private static By LBL_PRODUCTNAME = By.xpath("//h1[@class='proName']");
    private static By BTN_WISHLIST = By.xpath("//a[@id='getWishList']");
    private static By BTN_ADDFAVOURITE = By.xpath("//a[@id=\"addToFavouriteWishListBtn\"]");
    private static By BTN_OK = By.xpath("//span[@class='btn btnBlack confirm']");
    private static By DIV_MYACCOUNT = By.xpath("//div[@class='myAccountHolder customMenuItem hasMenu withLocalization']");
    private static By BTN_FAVOURITE = By.xpath("//a[text()='Favorilerim / Listelerim']");

    public String getProductName() {
        logInfo("Read product name");
        return getText(LBL_PRODUCTNAME);
    }

    public ProductPage addWishList() throws InterruptedException {
        if (isElementPresent(BTN_WISHLIST)) {
            logInfo("Whislist button is clicked");
            clickElement(BTN_WISHLIST);
            sleep(1000);
            clickElement(BTN_ADDFAVOURITE);
            if (isElementPresent(BTN_OK))
                clickElement(BTN_OK);
        } else
            logFatal("Wishlist button couldn't find");
        return this;
    }

    public ProductPage clickWishList() throws InterruptedException {
        logInfo("Clicks wishlist");
        mouseHover(DIV_MYACCOUNT);
        sleep(1000);
        clickElement(BTN_FAVOURITE);
        return this;
    }
}
