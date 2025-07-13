package com.eurotech.tests.day_08_TestNG_Intro;

import org.testng.annotations.*;

public class C02_BeforeAfterMethod {

    @Test
    public void test1(){               //testler alfabetik siraya gore calisir!!!
        System.out.println("test 1");
    }
    @Test @Ignore                       //(enabled = false) de yapabiliriz ignore yerine.... boylelikle bu methodu calistirmaz
    public void test2(){
        System.out.println("test 2");
    }
    @Test (priority = 2)                //bu seklide siralamasini degistirebiliriz.
    public void test3(){
        System.out.println("test 3");
    }
    @Test                       //priorty girilmez ise default olarak "0" atanir ve ilk o test calisir
    public void test4(){
        System.out.println("test 4");
    }


    @BeforeMethod
    public void setUp(){   //before method ,bu boyle adlandirilir.method adi
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown(){   // after method icin kullanilir...method adi
        System.out.println("After Method");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("before class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("after class");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }




}
