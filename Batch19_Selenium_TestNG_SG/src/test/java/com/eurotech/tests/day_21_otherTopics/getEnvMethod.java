package com.eurotech.tests.day_21_otherTopics;

import org.testng.annotations.Test;

public class getEnvMethod {
    /**
     * enviroment variablesta bulunan degiskenlere erismek icin kullanilir
     */

    @Test
    public void test1(){
        String pass = System.getenv("passwordTest19");
        System.out.println("pass = " + pass);
    }
}
