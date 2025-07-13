package com.eurotech.tests.day_10_listOfElements_Dropdowns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class C02_DropdownsWithSelectTag {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){driver= WebDriverFactory.getDriver("chrome");}

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);driver.close();}

    @Test
    public void dropDownWithSelectTag() throws InterruptedException {
        /**
         * Select Menu
         * go to https://demoqa.com/select-menu
         * locate Old Style Select Menu (dropdown menu)
         * get all colorsOptions(web elements) as a list
         * verify that the number of webElement is 11
         * click (select) green
         * verify that the selected option's text is 'Green'
         */
        driver.get("https://demoqa.com/select-menu");
        WebElement colorsSelectMenu = driver.findElement(By.id("oldSelectMenu"));

        //Selenium tag'i ile hazirlanmis dropdawn menuler icin ekstra bir class hazirlamistir.

        Select select = new Select(colorsSelectMenu);

        List<WebElement> colors = select.getOptions();

        int actualSize = colors.size();
        int exceptedSize = 11;

        Assert.assertEquals(actualSize,exceptedSize);

        for (WebElement color : colors) {
            System.out.println(color.getText());
        }

        colors.get(2).click(); //green secildi
        Thread.sleep(2000);

        WebElement greenElement = select.getFirstSelectedOption();

        String actualText = greenElement.getText();
        String exceptedText = "Green";
        Thread.sleep(2000);
        Assert.assertEquals(actualText,exceptedText);

     /**
     * HANDLE DROPDOWNS WITHOUT GETTING INTO LIST
     *
     * select the blue option by visible text method
     * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
     * verify that the selected option's text is 'Blue'
     */

     select.selectByVisibleText("Blue");
     WebElement blueElement=select.getFirstSelectedOption();

     String actualText_1 = blueElement.getText();
     String exceptedText_1 = "Blue";
     Thread.sleep(2000);

     Assert.assertEquals(actualText_1,exceptedText_1);


     /**
     * select the black option by index method
     * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
     * verify that the selected option's text is 'Black'
     */
     select.selectByIndex(5);
        Thread.sleep(2000);
     WebElement blackElement = select.getFirstSelectedOption();

     String actualText_2 = blackElement.getText();
     String exceptedText_2 = "Black";

     Assert.assertEquals(actualText_2,exceptedText_2);


      /**
     * select the voilet option by value attribute method
     * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
     * verify that the selected option's text is 'Voilet'
     */
     select.selectByValue("7");
      Thread.sleep(2000);

     WebElement voiletElement = select.getFirstSelectedOption();

     String actualText_3 = voiletElement.getText();
     String exceptedText_3 = "Voilet";

     Assert.assertEquals(actualText_3,exceptedText_3);

     // görünen textin bir bölümü ile seçme yapmak istersek
     // Indigo'yu seçelim.
     select.selectByContainsVisibleText("digo");


    }
    @Test
    public void dropDownWithSelectTag_Task() throws InterruptedException {
        /** CLASS TASK
         * navigate to https://www.amazon.com.tr/"
         * accept cookies if any
         * locate the dropdown menu nearby the search box
         * get all departments(web elements) as a list
         * verify that the number of webElement is 22
         * click (select) "Oyuncaklar ve Oyunlar" with index:16
         * verify that the selected option's text is 'PC ve Video Oyunları'
         */

        driver.get("https://www.amazon.com.tr/");
        //cookies
        driver.findElement(By.id("sp-cc-accept")).click();
        Thread.sleep(2000);

        WebElement searchDropdownBox = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(searchDropdownBox);

        List<WebElement> departments = select.getOptions();
        departments.get(16).click();
        WebElement firstSelectedOption = select.getFirstSelectedOption();

        String actualText=firstSelectedOption.getText();
        String expectedText="Oyuncaklar ve Oyunlar";

        Assert.assertEquals(actualText,expectedText);

        Assert.assertEquals(departments.size(),22);

        /** select the "Baby" department by using visible text
         * then verify the department name
         */

        select.selectByVisibleText("Bebek");
        firstSelectedOption=select.getFirstSelectedOption();
        actualText=firstSelectedOption.getText();
        expectedText="Bebek";
        Thread.sleep(2000);

    }

}

/**
 * AÇIKLAMALAR:
 * Özel bir web element yapısına sahiptir.
 * İki yolla locate edilirler.
 *
 * 1. Normal yol --> Web element bilinen yollar ile locate edilir ve manual olarak yapılan işlemler koda aktarılır.
 * Note: Eğer menüdeki elementleri inspect yapamıyorsanız
 * --> right click/inspect/eventlisteners/blur burada bulunan bütün seçenekler silinir.
 *
 * 2.Select class --> Eğer dropdown elementi select tagı ile yapılmışsa seleniumdan gelen
 * 'Select' class bu menudeki opsiyonlarla iletişime geçmek için kullanılır.
 * 2.1. Dropdown web elementi locate edilir (select tagıyla olan yer) -->
 * WebElement dropDown = driver.findElement(By.xpath("formula"));
 *
 * 2.2. Select classından bir select nesnesi oluşturulur. --> Select select = new Select(dropDown);
 * 2.2.1 select.getOptions() --> menudeki bütün seçenekleri bir WebElement liste alır.
 * 2.2.2 select.selectByVisibleText("...") --> görünen texte göre elementi seçtirir.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 * 2.2.3 select.selectByIndex("...") --> index (sıra no) ile elementi seçtirir.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 * 2.2.4 select.selectByValue("...") value attribute değeri ile elementi seçtiri.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 */
