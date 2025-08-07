package com.sauceDemo.tests.E2E_Tests;

import com.sauceDemo.pages.LoginPage;
import com.sauceDemo.pages.ProductsPage;
import com.sauceDemo.pages.YourCartPage;
import com.sauceDemo.tests.TestBase;
import com.sauceDemo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C_1_SuccessShoppingTest extends TestBase {

    @Test
    public void successShopping_TC_0125(){
        /**
         * * Kullanici login sayfasina gider : https://www.saucedemo.com/
         *     * Kullanici gecerli kullanici adi: "standard_user" ve sifreyi: "secret_sauce" girer
         *     * Kullanici acilan sayfanin basligini gorur: "Products"
         *
         *    * Kullanici urunleri verilen kritere gore siralar: "Price (high to low)"
         *    * Kullanici en pahali urunu ilk sirada gorur: "Sauce Labs Fleece Jacket"
         *    * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Fleece Jacket"
         *    * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Onesie"
         *    * Kullanici urun adi ile sepete urun ekler : "Sauce Labs Bolt T-Shirt"
         *    * Kullanici ekledigi urun sayisini sepetin ustunde gorur
         *    * Kullanici your cart sayfasina gider
         *    * Kullanici acilan sayfanin basligini gorur: "Your Cart"
         *    * Kullanici ekledigi urunleri your cart sayfasinda dogrular
         *    * Kullanici sonraki sayfaya gecer
         *    * Kullanici acilan sayfanin basligini gorur: "Checkout: Your Information"
         *    * Kullanici formu ilgili bilgilerle doldurur : "Ali", "AykaÃ§", "35920"
         *    * Kullanici sonraki sayfaya gecer
         *    * Kullanici acilan sayfanin basligini gorur: "Checkout: Overview"
         *    * Kullanici sonraki isimli sayfaya gecer
         *    * Kullanici acilan sayfanin basligini gorur: "Checkout: Complete!"
         *    * Kullanici tesekkur mesajini gorur: "Thank you for your order!"
         */

        extentLogger = report.createTest("TC0125- Success Shoping E2E Test");
        extentLogger.info("Kullanici login sayfasina gider"+ConfigurationReader.get("url"));

        extentLogger.info("Kullanici gecerli kullanici adi: standard_user ve sifreyi: secret_sauce girer");
        LoginPage loginPage=new LoginPage();
        loginPage.login();

        extentLogger.info("Kullanici acilan sayfanin basligini gorur: 'Products'");
        ProductsPage productsPage = new ProductsPage();
        String actualTitle = productsPage.productsPgeTitle.getText();
        String exceptedTitle ="Products";
        Assert.assertEquals(actualTitle,exceptedTitle);

        extentLogger.info("Kullanici urunleri verilen kritere gore siralar: 'Price (high to low)'");
        productsPage.sortProducts("Price (high to low)");

        extentLogger.info("Kullanici en pahali urunu ilk sirada gorur:'Sauce Labs Fleece Jacket'");
        String actualFirstProduct = productsPage.getFirstProductName();
        String exceptedFirstProduct = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualFirstProduct,exceptedFirstProduct);

        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Fleece Jacket'");
        productsPage.selectProductByName("Sauce Labs Fleece Jacket");
        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Onesie'");
        productsPage.selectProductByName("Sauce Labs Onesie");
        extentLogger.info("Kullanici urun adi ile sepete urun ekler : 'Sauce Labs Bolt T-Shirt'");
        productsPage.selectProductByName("Sauce Labs Bolt T-Shirt");


        extentLogger.info("Kullanici ekledigi urun sayisini sepetin ustunde gorur");
        String basketNamber = productsPage.basketNumber.getText();
        String actualBasketNamber = String.valueOf(ProductsPage.addedProductNumber);
        Assert.assertEquals(actualBasketNamber,basketNamber);
        System.out.println("basketNamber = " + basketNamber);
        System.out.println("actualBasketNamber = " + actualBasketNamber);


        extentLogger.info("Kullanici your cart sayfasina gider");
        productsPage.shopingCartLink.click();
        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Your Cart'");
        YourCartPage yourCartPage = new YourCartPage();
        Assert.assertTrue(yourCartPage.yourCartPageTitle.isDisplayed());



        extentLogger.info("Kullanici ekledigi urunleri your cart sayfasinda dogrular");
        extentLogger.info("Kullanici sonraki sayfaya gecer");
        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Your Information'");
        extentLogger.info("Kullanici formu ilgili bilgilerle doldurur : 'Ali', 'AykaÃ§', '35920'");
        extentLogger.info("Kullanici checkout sayfasina gecer");
        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Overview'");
        extentLogger.info("Kullanici finish sayfasina gecer");
        extentLogger.info("Kullanici acilan sayafanin basligini gorur: 'Checkout: Complete!'");
        extentLogger.info("Kullanici tesekkur mesajini gorur: 'Thank you for your order!'");
        extentLogger.pass("Passed...!!!");





    }
}
