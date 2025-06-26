package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_ClickAndSendKeysGetText_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         *      HOMEWORK
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.de/");



        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Java");

        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));

        searchBtn.click();

        Thread.sleep(2000);

        WebElement resultText = driver.findElement(By.xpath("//span[contains(text(),'Ergebnissen')]"));

        String text = resultText.getText();
        WebElement keywordJava = driver.findElement(By.cssSelector("[class=\"a-color-state a-text-bold\"]"));
        String text1 = keywordJava.getText();

        System.out.println("Result text: " + text);

        if(text1.contains("Java"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");


        driver.quit();


    }
}
