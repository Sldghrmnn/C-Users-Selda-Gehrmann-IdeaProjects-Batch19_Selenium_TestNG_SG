package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.Test;

public class AddExperiencePage extends BasePage{

    @FindBy(xpath = "//div/button[text()='Add Experience']")
    public WebElement addExperienceBtn;

    @FindBy(xpath = "//input[@id='job']")
    public WebElement jobBox;

   @FindBy(xpath = "(//textarea[@id='description'])[1]")
    public WebElement jobDescriptionBox;

@FindBy(xpath = "//input[@id='job']")
        public WebElement jobTitleBox ;

@FindBy(xpath = "(//input[@id='company'])[2]")
    public WebElement companyBox;

@FindBy(xpath = "//input[@placeholder='Location']")
   public WebElement locationBox;

@FindBy(xpath = "(//input[@id='fromdate'])[1]")
   public WebElement fromDateBox;

@FindBy(xpath ="//input[@id='todateexp']" )
    public WebElement toDateBox;

@FindBy(xpath = "//textarea[@placeholder='Job Description']")
   public  WebElement jobDescBox;

    public void fillingAddExperienceForm() {
        jobTitleBox.sendKeys("QA Engineer");
        companyBox.sendKeys("SAP");
        locationBox.sendKeys("Wiesloch");
        fromDateBox.sendKeys("01012020");
        toDateBox.sendKeys("01012025");
        jobDescBox.sendKeys("Manuel Tester");

    }


}
