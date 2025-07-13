package com.eurotech.tests.day_08_TestNG_Intro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C03_TestNG_AssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("*******OPEN BROWSER*******");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("*******CLOSE BROWSER*******");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("Ayse3","Ayse"); //burda veilen ve beklenen tutmadiginda( sari dairede carpi isareti) olusur

        System.out.println("Second Assertion");
        Assert.assertEquals("Alper","Alper");
    }
    @Test
    public void test2(){
        System.out.println("Third Assertion");
        Assert.assertEquals("url","url");
        int i = 5/0;                      //exception hatasi vardir burda( kirmizi daire icinde ünlem isareti) olur
        System.out.println("code Contiunes");
    }
    @Test
    public void test3(){
        System.out.println("Fourth Assertion");
        Assert.assertEquals(150,150,"Verify that integer values must be equal");
        // gecen test,( yesil tik isareti) verir
    }
    @Test
    public void test4(){
        String str1 = "Eurotech";
        String str2 = "Euro";

        String str3 = "aaaaaaa.com";

        Assert.assertTrue(str1.startsWith(str2));
        Assert.assertTrue(str3.contains("@"),"verify that mail contains @");
        //mesaj kismi assertion gecmediginde yazdirlir.
    }
    @Test
    public void test5(){
        String str = "eurotech";
        Assert.assertFalse(str.contains("@"));

        Assert.assertFalse(1<0);
    }
    @Test
    public void test6(){
        String str = "Leeroy";
        String str2 =""; // is empty
        String str3 =" ";// is blank
        String str4 =null;//null
        String str5;  //null

        Assert.assertNull(str4);
        Assert.assertNotNull(str2);


    }
}
