package com.eurotech.tests.day_15_properties_singleton;

public class C02_SingletonDemo {
    private C02_SingletonDemo(){}
        //private constructor sayesinde bu class'tan obje (instance) uretilemez.

    private static String driver;

    public static String getDriver(){
        if (driver == null){
            System.out.println("driver bostur,ona deger atayiniz");
            driver = "firefox";
        }else{
            System.out.println("driver bos degildir,size mevcut driver'i donuyorum.");
        }
        return driver;
    }
}
