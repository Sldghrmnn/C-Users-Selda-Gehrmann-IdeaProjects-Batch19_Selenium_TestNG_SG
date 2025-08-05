package com.eurotech.tests.day_20_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C03_DataProviderDemo {

    @DataProvider
    public Object[][] notesData(){
        String [][] notes = {
                {"Hasan Kaya","70","85"},
                {"Asli Sönmez","100","62"},
                {"Emine Akay","88","25"},
                {"Ramazan Tolu","89","80"}
        };
        return notes;
    }

    @Test (dataProvider = "notesData")
    public void notes(String name,String vizaNote,String finalNote){
        System.out.println(name + " : " + vizaNote + " -> " + finalNote);
    }



    @DataProvider (name = "notlar")
    public Object[][] notesData_1(){
        Object [][] notes = {
                {"Hasan Kaya",70,85},
                {"Asli Sönmez",100,62},
                {"Emine Akay",88,25},
                {"Ramazan Tolu",89,80}
        };
        return notes;
    }

    @Test (dataProvider = "notlar")
    public void notes_1(String name,int vizaNote,int finalNote){
        System.out.println(name + " : " + vizaNote + " -> " + finalNote + "Yil Sonu Notu : "+ (vizaNote * 0.4 + finalNote * 0.6));
    }
}
