package com.eurotech.tests.day_08_TestNG_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://sdettest.eurotechstudy.eu/login");
        Thread.sleep(2000);

        WebElement thirdElement = driver.findElement(By.xpath(thirdElementMethodu(1)));
        thirdElement.sendKeys("abc@example.com");
        WebElement thirdElement2 = driver.findElement(By.xpath(thirdElementMethodu(2)));
        thirdElement2.sendKeys("Aa123456");
        Thread.sleep(2000);
        WebElement thirdElement3 = driver.findElement(By.xpath(thirdElementMethodu(3)));
        thirdElement3.click();
        Thread.sleep(2000);

        driver.close();

    }
    public static String  thirdElementMethodu(int num){
        String xppathWay= "(//form//input[@type='text'or @type='password'] | //button[text()='Login'])["+num+"]";
        return xppathWay;
    }
}




