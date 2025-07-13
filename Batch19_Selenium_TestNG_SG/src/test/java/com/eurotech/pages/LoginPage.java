package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{
    /**
     * PageFactory.initElements()  webElement'leri locato etmek icin gerekli olan By Class'inin tanimla hale gelir
     *
     * aksi halde
     * @FindBy ile tanimlanan elementler null olarak kalir
     * NullPointerException alinir
     */


  //  public LoginPage(){
  //      PageFactory.initElements(Driver.get(),this);
  //  }

    // WebElement emailBox = driver.findElement(By.id("email"));

    @FindBy(id="email")
    public static WebElement emailBox;

    @FindBy(id="yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button")
    public WebElement loginBtn;

    // AND logic ile çalışır... Yani verilen tüm locator lara sahip olan webElement i bulur
    @FindBys({
            @FindBy(id = "email"),
            @FindBy(xpath = "//input[@name='email']")
    })
    public WebElement emailBoxWithFindBys;



    //or logic ile calisir.Verilen locator'lara iliskin butun webElemenleri bulup getirir.(cogul donebilir)

    @FindAll({
            @FindBy(css ="#yourPassword"),
            @FindBy(css = ".samet")
    })
    public WebElement passwordBoxWithFindAll;

    @FindBy(xpath = "//div[contains(text(),'Password is incorrect. Please check')]")
    public WebElement wrongPasswordMessage;

    @FindBy(xpath = "//div[contains(text(),'Email address is incorrect. Please check')]")
    public WebElement wrongUserEmailMessage;

    @FindBy (css = "[role=\"alert\"]")
    public WebElement wrongCrendtialMessage;

    @FindBy(css = ".form-control,button")
    public List<WebElement> loginInputs;



    public void login(){
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

    public void login(String userEmail,String password){
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }
}
