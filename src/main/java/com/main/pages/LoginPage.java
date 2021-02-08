package com.main.pages;

import com.main.base.BaseMethods;
import org.openqa.selenium.By;
import sun.rmi.runtime.Log;

import static java.lang.Thread.sleep;

public class LoginPage extends BaseMethods {
    private static By INP_USERNAME = By.xpath("//input[@id='email']");
    private static By INP_PASSWORD = By.xpath("//input[@id='password']");
    private static By BTN_LOGIN = By.xpath("//div[@id='loginButton']");
    private static By CB_REMEMBER = By.xpath("//*[@class='rememberMe']");

    public LoginPage writeUsername(String username) {
        logInfo("Username is wrote");
        if (isElementPresent(INP_USERNAME))
            sendKeys(INP_USERNAME, username);
        else
            logFatal("Username input field couldn't find");
        return this;
    }

    public LoginPage writePassword(String password) {
        logInfo("Password is wrote");
        if (isElementPresent(INP_PASSWORD))
            sendKeys(INP_PASSWORD, password);
        else
            logFatal("Password input field couldn't find");
        return this;
    }

    public LoginPage clickRememberMe() {
        logInfo("Remember me checkbox is clicked");
        clickElement(CB_REMEMBER);
        return this;
    }

    public LoginPage clickLoginButton() throws InterruptedException {
        logInfo("Login button is clicked");
        sleep(2000);
        if (isElementPresent(BTN_LOGIN))
            clickElement(BTN_LOGIN);
        else
            logFatal("Login button couldn't find");
        return this;
    }
}

