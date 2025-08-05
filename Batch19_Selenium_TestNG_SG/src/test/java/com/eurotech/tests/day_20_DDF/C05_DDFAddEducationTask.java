package com.eurotech.tests.day_20_DDF;

import com.eurotech.pages.AddEducationPage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C05_DDFAddEducationTask extends TestBase {
    /**
     * Make add education test with DDF (Excel File)
     * Use LoginList.xlsx and QaTeam3 sheet
     * Report's name should arrange dynamically
     * Use parameterized add education method
     */
    @DataProvider
    public Object [][] userData(){
        ExcelUtil educationAddQATeam3 = new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam3");
        String[][] qaTeam3Multi = educationAddQATeam3.getDataArrayWithoutFirstRow();

        return qaTeam3Multi;
    }
    @Test(dataProvider = "userData")
    public void addInformationInEducation(String email,String password,String username,String school,String degree,
                                          String study,String formDate,String toDate,String progDesc){
        extentLogger = report.createTest("TC-0014 "+username+" 'nin addEducation Testi");

        UserProfilePage userProfilePage = new UserProfilePage();
        AddEducationPage addEducationPage = new AddEducationPage();
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Eurotech login sayfasina gidilir.");
        extentLogger.info("Gecerli email/password girilir.");
        loginPage.login(email,password);

        extentLogger.info("Basarili login islemi email ile dogrulanir.");
        DashboardPage dashboardPage = new DashboardPage();

        String actualUserName = dashboardPage.userName.getText();
        Assert.assertEquals(actualUserName,username);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabs(username, "My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        extentLogger.info("Navigate to Add Education tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addEducationPage.addEducationBtn)).isDisplayed());

        extentLogger.info("Fill the form with parameterized method (use actions class)");
        addEducationPage.fillingAddEducationForm(school,degree,study,formDate,toDate,progDesc);

        extentLogger.info("Verify that added education record can be seen at user profile page... (assert with school name)");
        String lastAddedSchoolName = userProfilePage.lastAddedSchoolName(school);
        String exceptedSchoolName = school;
        Assert.assertEquals(lastAddedSchoolName, exceptedSchoolName);

        extentLogger.info("Delete last added education record");
        userProfilePage.deleteLastAddedInfoRecord(school);

        extentLogger.pass("Passed...!!!");

    }
}
