package com.main;

import com.main.pages.*;
import org.junit.After;
import org.junit.Test;

import static com.main.Constants.*;
import static com.main.base.BaseMethods.close;
import static com.main.base.BaseMethods.logFatal;

public class n11 {

    @Test
    public void n11Product() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        WishListPage wishListPage = new WishListPage();

        homePage
                .pageLoadCheck()
                .closeGDPRText()
                .closeCoupon()
                .closeNotificationPanel()
                .clickLogin();
        loginPage
                .writeUsername(userName)
                .writePassword(password)
                .clickRememberMe()
                .clickLoginButton();
        homePage
                .loginCheck(userData)
                .searchProduct(product)
                .searchCheck(product)
                .clickSecondPage()
                .checkSecondPageLoad()
                .clickThirdProduct();

        String productName = productPage.getProductName();

        productPage
                .addWishList()
                .clickWishList();
        wishListPage
                .clickFavourites();

        if (!productName.equals(wishListPage.readProductName()))
            logFatal("The product in the wishlist is not product added");

        wishListPage
                .deleteProduct()
                .checkProductDeleted();
    }

    @After
    public void tearDown() {
        close();
    }
}
