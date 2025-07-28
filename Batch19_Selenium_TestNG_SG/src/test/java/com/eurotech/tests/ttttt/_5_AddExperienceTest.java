package com.eurotech.tests.ttttt;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.testng.annotations.Test;

public class _5_AddExperienceTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
 //   UserProfilePage userProfilePage;
  //  AddExperiencePage addExperiencePage;

    @Test
    public void addExperienceTest() {
        /**
         1-go to kraft login page
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

//        loginPage = new LoginPage();
//        dashboardPage = new DashboardPage();
//        userProfilePage = new UserProfilePage();
//        addExperiencePage = new AddExperiencePage();
//
//        loginPage.login();
//
//        BrowserUtils.waitForVisibility(dashboardPage.userName, 5);
//
//        String actualUserName = dashboardPage.userName.getText();
//        String expectedUserName = ConfigurationReader.get("userName");
//        Assert.assertEquals(actualUserName, expectedUserName, "usernames should be same");
//
//        dashboardPage.navigateToTabsAndModules(ConfigurationReader.get("userName"), "My Profile");
//
//        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 5);
//        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());
//
//        userProfilePage.navigateUserProfileMenu("Add Experience");
//
//        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn, 5).isDisplayed());
//
//        addExperiencePage.addExperienceMtd();
//
//        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle, 2);
//
//        String actualExperienceRecord = userProfilePage.addedExperienceName(addExperiencePage.jobTitleName);
//        String expectedExperienceRecord = addExperiencePage.jobTitleName;
//
//        Assert.assertEquals(actualExperienceRecord, expectedExperienceRecord);
//
//        userProfilePage.deleteExperience(addExperiencePage.jobTitleName);
    }
}
