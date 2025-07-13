package com.eurotech.tests.day_15_properties_singleton;

import org.testng.annotations.Test;

public class C03_SingletonDemoTest {

    @Test
    public void test1(){
      //  C02_SingletonDemo c02SingletonDemo = new C02_SingletonDemo();bu classtan obje uretilemez.

        String driver = C02_SingletonDemo.getDriver();
        System.out.println("driver = " + driver);

        System.out.println("-------------");

        String driver1 = C02_SingletonDemo.getDriver();
        System.out.println("driver1 = " + driver1);
    }
}
