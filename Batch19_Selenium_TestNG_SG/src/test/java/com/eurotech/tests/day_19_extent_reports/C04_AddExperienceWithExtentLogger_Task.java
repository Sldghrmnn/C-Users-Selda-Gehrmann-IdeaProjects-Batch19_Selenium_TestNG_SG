package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class C04_AddExperienceWithExtentLogger_Task extends TestBase {
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

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    UserProfilePage userProfilePage = new UserProfilePage();
    AddExperiencePage addExperiencePage = new AddExperiencePage();


}
