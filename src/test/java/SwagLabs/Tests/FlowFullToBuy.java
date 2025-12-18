package SwagLabs.Tests;

import SwagLabs.pages.CartPage;
import SwagLabs.pages.LoginPage;
import SwagLabs.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FlowFullToBuy {
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
     System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");

        try{
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage(driver);
            mainPage = new MainPage(driver);
            cartPage = new CartPage(driver);

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Test(priority = 1, description = "Flujo completo para comprar")
    public void flowFullToBuy(){
        loginPage.login("standard_user", "secret_sauce");
        mainPage.addItemToCart("Sauce Labs Backpack");
        cartPage.goTo();
        cartPage.comprobateProductInCart("Sauce Labs Backpack");
        cartPage.clickCheckoutButton();
        cartPage.clickContinueCheckoutButton("John", "Doe", "99999");
        cartPage.clickFinishButton();
    }


    @AfterMethod
    public void closeBrowser(){ driver.quit(); }

}
