package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_deneme {
    public static void main(String[] args) throws InterruptedException {
/*Chrome tarayıcısını aç.

https://www.saucedemo.com/ adresine git.

Kullanıcı adı kutusuna standard_user yaz.

Şifre kutusuna yanlış bir şifre yaz (örneğin wrong_password).

"Login" butonuna tıkla.

Ekranda görünen hata mesajını bul.

Hata mesajının "Username and password do not match" ifadesini içerdiğini doğrula.
*/

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement passwordBox = driver.findElement(By.cssSelector("[placeholder=\"Password\"]"));
       // WebElement passwordBox2 = driver.findElement(By.id("password"));
        passwordBox.sendKeys(" wrong_password");

        WebElement BtnLogin = driver.findElement(By.id("login-button"));
        BtnLogin.click();

        Thread.sleep(2000);

        String validationMessage = passwordBox.getAttribute("validationMessage");
        Thread.sleep(2000);
        System.out.println("validationMessage = " + validationMessage);


        String expectedMessage ="Username and password do not match";

        if (validationMessage.contains(expectedMessage))
            System.out.println("pass...");
        else
            System.out.println("fail...");

        driver.close();
/*
WebElement errorMsg = driver.findElement(By.cssSelector("[data-test=\"error\"]"));
Thread.sleep(2000);
System.out.println("errorMsg.getText() = " + errorMsg.getText());
String message = errorMsg.getText();



*/





    }
}
