package com.eurotech.tests.day_08_TestNG_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeWork1 {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='İzin ver']")).click();

        viewProduct("Blue Top");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.close();
    }
    private static void viewProduct(String product){
        WebElement viewProductBtn=driver.findElement(By.xpath("//p[text()='"+product+"']//ancestor::div[@class='product-image-wrapper']//li/a"));
        viewProductBtn.click();

    }

}
