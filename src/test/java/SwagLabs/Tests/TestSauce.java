package SwagLabs.Tests;

import SwagLabs.pages.CartPage;
import SwagLabs.pages.LoginPage;
import SwagLabs.pages.MainPage;
import com.google.gson.Gson;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("Automatización Web de SwagLabs")
@Feature("Validación de elementos")
public class TestSauce {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    WebDriverWait wait;


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1, description = "Inicio de sesión con usuario estandar")
    public void loginSession() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(5000);
    }

    @Test(priority = 2, description = "Vaciar carrito")
    public void emptyCart() {
        loginPage.login("standard_user", "secret_sauce");
        mainPage.addItemToCart("Sauce Labs Backpack");
        cartPage.goTo();
        cartPage.comprobateProductInCart("Sauce Labs Backpack");
        mainPage.clickReset();
        cartPage.comprobateEmptyCart();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
