package com.eurotech.tests.day_17_18_pom_cont;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_DashboardTest extends TestBase {

    @Test
    public void tabMenuTest(){
        /**
         * go to login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Zelda"
         */

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actualTitle = dashboardPage.pageTitleLeftTop.getText();
        String exceptedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,exceptedTitle,"TC001- Verifying dashboard page title");

         List<WebElement> tabMenuElements= dashboardPage.tabMenu;

         List<String> tabMenuNames= new ArrayList<>();

         for (WebElement  tabMenuElement :tabMenuElements ) {
             tabMenuNames.add(tabMenuElement.getText());
         }

         List<String> exceptedTabNames = new ArrayList<>(Arrays.asList("Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Zelda"));

         Assert.assertEquals(tabMenuNames,exceptedTabNames);

    }
    @Test
    public void tabMenuTest2(){
        /**
         * go to login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Zelda"
         */

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actualTitle = dashboardPage.pageTitleLeftTop.getText();
        String exceptedTitle = "Dashboard";

        Assert.assertEquals(actualTitle,exceptedTitle,"TC001- Verifying dashboard page title");

        List<String> tabMenuNames = BrowserUtils.getElementsText(dashboardPage.tabMenu);


        List<String> exceptedTabNames = new ArrayList<>
                (Arrays.asList("Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Zelda"));

        Assert.assertEquals(tabMenuNames,exceptedTabNames);
    }

    @Test
    public void navigateTabMenu(){
        /**
         * login with valid credentials
         * go to 'Developers' tab via navigateToTabs()
         * validate that you are on the right page through url
         * expectedUrl = https://sdettest.eurotechstudy.eu/developers
         */

         LoginPage loginPage= new LoginPage();
         loginPage.login();

         DashboardPage dashboardPage= new DashboardPage();
         dashboardPage.navigateToTabs("Developers");

         String actualURL= driver.getCurrentUrl();
         String exceptedURL = "https://sdettest.eurotechstudy.eu/developers";

         Assert.assertEquals(actualURL,exceptedURL);

    }

    @Test
    public void navigateTabMenu_1(){
        /**
         * login with valid credentials
         * go to 'Components --> Modal' submodule via navigateToTabsAndModule( two parameters)
         * validate that you are on the right page through url
         * expected url : https://sdettest.eurotechstudy.eu/components/modal
         *
         * then navigate to Developer tab and make verification with url
         */
        LoginPage loginPage= new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToTabs("Components","Modal");

        String actualURL= driver.getCurrentUrl();
        String exceptedURL = "https://sdettest.eurotechstudy.eu/components/modal";

        Assert.assertEquals(actualURL,exceptedURL);

        dashboardPage.navigateToTabs("Developers");
        String actualURL1= driver.getCurrentUrl();
        String exceptedURL1 = "https://sdettest.eurotechstudy.eu/developers";

        Assert.assertEquals(actualURL1,exceptedURL1);
    }
}
