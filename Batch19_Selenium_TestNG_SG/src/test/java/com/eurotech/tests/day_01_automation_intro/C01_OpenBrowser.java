package com.eurotech.tests.day_01_automation_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_OpenBrowser {
    public static void main(String[] args) {
        //1. Selenium'u chrome ile konusacak hale getirecegiz.
        //2. Bir driver objesi uretecegiz.
        //3. Driver --> bos bir browser'i temsil eder.

        WebDriver driver = new ChromeDriver(); //polymorphic bir tanimlama

        // amazon web sayfasina gidelim
        driver.get("https://www.amazon.de");

        // amazon web sitesinin page title'i alalim

        String acualTiltle = driver.getTitle();
        System.out.println("acualTiltle = " + acualTiltle);

        String expectedTitle ="Amazon.de: Günstige Preise für Elektronik & Foto,"+
                " Filme, Musik, Bücher, Games, Spielzeug & mehr";


        if (acualTiltle.equals(expectedTitle))
            System.out.println("Pass...!");

        else
            System.out.println("Failed...!!!");
    }
}
