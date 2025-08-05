package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_AddExperienceWithExtentLogger_Task extends TestBase {

    @Test
    public void addExperienceTest1() {
        /**
         1-navigate to https://sdettest.eurotechstudy.eu/login
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        extentLogger = report.createTest("TC130 Add Experience Test");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        AddExperiencePage addExperiencePage = new AddExperiencePage();

        extentLogger.info("navigate to " + ConfigurationReader.get("url") + "login");
        extentLogger.info("make login");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName)).isDisplayed());

        String actualUserName = dashboardPage.userName.getText();
        String exceptedUserName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName, exceptedUserName);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"), "My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        extentLogger.info("Navigate to Add Experience tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Experience");

        extentLogger.info("Verify that add experince page is displayed");
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addExperiencePage.addExperienceBtn)).isDisplayed());

        extentLogger.info("Fill the form with non-parameterized method");
        addExperiencePage.fillingAddExperienceForm();

        extentLogger.info("Verify that added experience record can be seen at user profile page");
        addExperiencePage.addExperienceBtn.click();

        extentLogger.info("Delete last added experience record");
        userProfilePage.deleteLastAddedInfoRecord("QA Engineer");

        extentLogger.pass("Passed...!!!");


    }
}