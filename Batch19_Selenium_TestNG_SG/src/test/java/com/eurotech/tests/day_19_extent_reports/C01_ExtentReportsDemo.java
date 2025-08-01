package com.eurotech.tests.day_19_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_ExtentReportsDemo {

    //Bu class rapor olusturmak ve rapor ile ilgili metadata'yi tanimlamak icin kullanilir.
    ExtentReports report;

    //Bu class raporumuzun HTML formatinda olmsini saglar
    ExtentHtmlReporter htmlReporter;

    //Her test ile ilgili log kayitlari almamizi ve test asteplerini tanimlamamizi saglar.
    ExtentTest extentLogger;

    @BeforeMethod
    public void before(){
        //rapor objemizi initialize edelim.
        report = new ExtentReports();

        //raporun kayit edilecegi yeri belirleyelim.(path)
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";

        //html raporumuzu path ile olusturalim.
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //html raporumuzu report objesi ile iliskilendirelim (attach)
        report.attachReporter(htmlReporter);

        //raporumuza baslik verelim.
        htmlReporter.config().setReportName("Smoke Test");

        //raporumuzun environmet (metadata) bilgilerini duzenleyelim.
        report.setSystemInfo("Environmet","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer",ConfigurationReader.get("userName"));
        report.setSystemInfo("PO","Suleyman Suleyman");

    }
    @Test
    public void test1(){
        //mevcut bu testimizin adini girelim
        extentLogger = report.createTest("TC001 Demo Test");

        //test adimlarini teker teker girelim
        extentLogger.info("chrome browser'i ac");
        //kod buraya yazillacak - code here

        extentLogger.info("Web sayfasina git");
        //kod buraya yazillacak - code here

        extentLogger.info("email gir");
        //kod buraya yazillacak - code here

        extentLogger.info("password gir");
        //kod buraya yazillacak - code here

        extentLogger.info("login buttona click yap");
        //kod buraya yazillacak - code here

        extentLogger.info("login oldugunuzu kullanici adi ile dogrula :"+ConfigurationReader.get("userName"));
        //kod buraya yazillacak - code here

        extentLogger.pass("Passed...!!!");

    }
    @AfterMethod
    public void after(){
        //raporun gercek anlamda olusturuldugu yer
        report.flush();
    }
}
