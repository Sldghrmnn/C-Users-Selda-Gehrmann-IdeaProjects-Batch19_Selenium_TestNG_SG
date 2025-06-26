package com.eurotech.tests.day_02_webdriver_basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C01_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back -geri gelin
         * then navigate forward- ileri gelin
         * then refresh page -sayfayi yenile
         * then close driver
         */

        //set up a chrome driver
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        //navigate to https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");

        Thread.sleep(2000);

        //then navigate to https://testrelic.com/
        driver.get(" https://testrelic.com/"); //siteyi ilk defa acacaksam get methoduyla acarim

       // then navigate back -geri gelin
        driver.navigate().back();  // nevigate ile get ile ilkdefa gidip kesfettigim coklu sayfasi olan siteyi caigirirz.
        Thread.sleep(2000);
        //        * then navigate forward- ileri gelin
        driver.navigate().forward();
        Thread.sleep(2000);
        //        * then refresh page -sayfayi yenile
        driver.navigate().refresh();
        //       * then close driver
        driver.close();




    }
}
