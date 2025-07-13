package com.eurotech.tests.day_09_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.extensions.compactnotation.PackageCompactConstructor;

public class C01_CheckBoxes {
    /**
     * Açıklamalar   :
     * isSelected()  ----> bir elementin seçili olup olmadığını verir  :  true/false
     * isDisplayed()  ----> bir elementin görünür olup olmadığını verir  :  true/false
     * isEnabled()  ----> bir element ile etkileşime (click, sendKeys vb.) geçilip geçilemeyeceğini verir  :  true/false
     *                    isEnabled() durumunun tersi disabled ile ifade edilir  ama isDisable() metodu yoktur...
     */
    WebDriver driver;  //class ici global bir degisken olarak driver objesi olusturalim//declarasyon
    @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome");//initalization
        // driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate option 3 element
         * verify that the element is selected
         * click the element
         * verify that the element is NOT selected
         *
         * locate option 2
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         */

        // //  WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(2000);

        //* locate option 3 element
        WebElement option3 = driver.findElement(By.cssSelector("[value='option-3']"));

        // * verify that the element is selected
        Assert.assertTrue(option3.isSelected());
        Thread.sleep(2000);

        // * click the element
        option3.click();
        Thread.sleep(2000);

        //* verify that the element is NOT selected
        Assert.assertFalse(option3.isSelected());
        Thread.sleep(2000);
    }
        @Test
    public void chackBoxTest2() throws InterruptedException {
            driver.get("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
            Thread.sleep(2000);

        WebElement option2 = driver.findElement(By.xpath("//*[text()='Option 2']/input"));

        //* verify that the element is NOT selected
        Assert.assertFalse(option2.isSelected());
        Thread.sleep(2000);

        //* click the element
        option2.click();
        Thread.sleep(2000);

        //* verify that the element is selected
        Assert.assertTrue(option2.isSelected());
        Thread.sleep(2000);

    }
    @Test
    public void checkboxTest_Task() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/checkboxes
         * locate both checkBoxes web elements
         * verify that checkbox 1 is NOT selected
         * verify that checkbox 2 is selected
         * click check box 1 and check box 2
         * verify that checkbox 1 is selected
         * verify that checkbox 2 is NOT selected
         */
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);
        //locate both checkBoxes web elements
        WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes>input:nth-child(1)"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(2)"));

        Assert.assertFalse(checkBox1.isSelected(), "verify that checkbox 1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(), "verify that checkbox 2 is selected");

        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();
        Thread.sleep(2000);

        Assert.assertTrue(checkBox1.isSelected(), "verify that checkbox 1 is selected");
        Assert.assertFalse(checkBox2.isSelected(), "verify that checkbox 2 is NOT selected");
    }
}
