package com.eurotech.tests.day_15_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C06_LoginTest_2 extends TestBase {
    @Test
    public void loginTest() throws InterruptedException {
        /**
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with url
         * https://sdettest.eurotechstudy.eu/index
         */

        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        Thread.sleep(1000);
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//localae tasindi tastbase de
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h2"))));

        String userName= driver.findElement(By.xpath("//h2")).getText();
        System.out.println("userName = " + userName);

        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl="https://sdettest.eurotechstudy.eu/index";

        Assert.assertEquals(actualUrl,exceptedUrl);
    }

    @Test
    public void loginTest_2(){
        /**
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with page title is:
         * Dashboard - EuroTech Lab - aFm
         */
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//h2"))));

       String actualTitle=driver.getTitle();
       String expectedTitle ="Dashboard - EuroTech Lab - aFm";

       Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void loginTest_3(){
        /** TASK
         * go to eurotechstudy login page
         * login with your credentials
         * validate that you are on the dashboard with page email is :
         * leeroyjenkins@email.com
         */
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.xpath("//button")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2"))));

        String actualUserEmail= driver.findElement(By.xpath("//div[text()='Email']/../div[@class=\"col-lg-9 col-md-8\"]")).getText();
        String expectedEmail="sld@gmail.com";
        Assert.assertEquals(actualUserEmail,expectedEmail);
    }
}
