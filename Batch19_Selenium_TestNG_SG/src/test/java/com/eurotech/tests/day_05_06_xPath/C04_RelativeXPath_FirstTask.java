package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_RelativeXPath_FirstTask {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Sign Up link (use xPath with text feature)
         * click the Sign Up link
         * locate Sign In link (use xPath with text feature)
         * get the text of element and print it
         * verify that the text is "Sign In"
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://www.eurotech.study/");

        Thread.sleep(2000);

        WebElement cookiesBtn = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
        cookiesBtn.click();
        Thread.sleep(1000);

        WebElement signUpBtn = driver.findElement(By.xpath("//a[text()='Sign Up']"));
        signUpBtn.click();
        Thread.sleep(2000);

        WebElement signInText = driver.findElement(By.xpath("//a[text()='Sign In']"));
        String signInLinkText = signInText.getText();
        System.out.println("signInLinkText = " + signInLinkText);

        if (signInLinkText.equals("Sign In"))
            System.out.println("Pass");
        else
            System.out.println("fail..!!");

        driver.close();
    }
}
