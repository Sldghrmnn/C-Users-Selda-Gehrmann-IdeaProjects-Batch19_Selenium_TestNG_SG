package com.eurotech.tests.day_09_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_DisabledElements {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void disableElements() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(2000);

        WebElement textBar = driver.findElement(By.cssSelector("#input-example>input"));
        //textBar.sendKeys("Leeroy Jenkins");

        // * verify that the element is disabled
        Assert.assertFalse(textBar.isEnabled());

        WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableBtn.click();
        Thread.sleep(3000);
        String sentence = "The element is now enabled!!";

        textBar.sendKeys(sentence);

        String actualValue= textBar.getAttribute("value");
        Assert.assertEquals(actualValue,sentence);


        Assert.assertTrue(textBar.isEnabled());


    }

    @Test
    public void disableElements_Task() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */

        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(2000);
        //locate pumpkin element
        WebElement pumpkin = driver.findElement(By.cssSelector("[value='pumpkin']"));

        // verify that the element is enabled
        // verify that the element is selected
        // verify that the element is displayed
        Assert.assertTrue(pumpkin.isEnabled());
        Assert.assertTrue(pumpkin.isSelected());
        Assert.assertTrue(pumpkin.isDisplayed());

        //locate cabbage element
        WebElement cabbage = driver.findElement(By.cssSelector("[value='cabbage']"));

        // verify that the element is NOT enabled
        // verify that the element is NOT selected
        // verify that the element is displayed
        Assert.assertFalse(cabbage.isEnabled());
        Assert.assertFalse(cabbage.isSelected());
        Assert.assertTrue(cabbage.isDisplayed());
    }
}
