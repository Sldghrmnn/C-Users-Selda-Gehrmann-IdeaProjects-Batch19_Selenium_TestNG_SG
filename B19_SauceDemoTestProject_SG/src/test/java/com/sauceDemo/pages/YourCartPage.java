package com.sauceDemo.pages;

import com.sauceDemo.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends TestBase {

    @FindBy(xpath = "//span[text()='Your Cart']")
    public WebElement yourCartPageTitle;
}
