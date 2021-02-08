package com.main.pages;

import com.main.base.BaseMethods;
import org.openqa.selenium.By;

public class WishListPage extends BaseMethods {
    private static By BTN_FAVOURITE = By.xpath("//h4[starts-with(text(),'Favorilerim')]");
    private static By LBL_PRODUCTNAME = By.xpath("//h3[@class='productName '][@itemprop='name']");
    private static By BTN_DELETE = By.xpath("//span[@class='deleteProFromFavorites']");

    public WishListPage clickFavourites() {
        logInfo("Favourites is clicked");
        clickElement(BTN_FAVOURITE);
        return this;
    }

    public String readProductName() {
        logInfo("Read product name");
        return getText(LBL_PRODUCTNAME);
    }

    public WishListPage deleteProduct() {
        logInfo("Delete button is clicked");
        clickElement(BTN_DELETE);
        return this;
    }

    public WishListPage checkProductDeleted() {
        logInfo("Check product deleted");
        if (isElementPresent(LBL_PRODUCTNAME))
            logFatal("Product couldn't delete");
        return this;
    }
}
