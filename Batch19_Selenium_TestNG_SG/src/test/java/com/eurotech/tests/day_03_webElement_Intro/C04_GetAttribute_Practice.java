package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * take the value of the attributes (class and href) of the login button and print the values.
         * click login button
         * send "sdfsdsd" into email address input box
         * click Login button
         * get the message which appears on the email input box
         * VERIFY that the message contains "Please include an '@' in the email address."
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" http://www.eurotech.study/");

        Thread.sleep(1000);

        //locate cookies button
        WebElement cookies = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();

        Thread.sleep(1000);

        //locate login button
        WebElement loginBtn = driver.findElement(By.cssSelector("[class='btn btn-light']"));

        //print attribute values
        System.out.println("loginBtn.getAttribute(\"class\") = " + loginBtn.getAttribute("class"));
        System.out.println("loginBtn.getAttribute(\"href\") = " + loginBtn.getAttribute("href"));

        loginBtn.click();

        Thread.sleep(1000);

        //locate email text box
        WebElement emailTextBox = driver.findElement(By.id("loginpage-input-email"));
        emailTextBox.sendKeys("sdfsdsd");

        //locate login button
        WebElement userLoginBox = driver.findElement(By.id("loginpage-form-btn"));
        userLoginBox.click();

        //email hata mesajini gonderme
        String validationMessage=emailTextBox.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);

        String expectedMessage ="Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"sdfsdsd\" adresinde \"@\" eksik.";

        if (validationMessage.equals(expectedMessage))
            System.out.println("pass");
        else
            System.out.println("fail");

        driver.close();




    }
}
