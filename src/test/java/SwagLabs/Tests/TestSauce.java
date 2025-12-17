package SwagLabs.Tests;

import SwagLabs.pages.LoginPage;
import com.google.gson.Gson;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automatización Web de SwagLabs")
@Feature("Validación de elementos")
public class TestSauce {
    WebDriver driver;
    LoginPage loginPage;
    Gson gson;
    String usersPath = "src\\test\\java\\SwagLabs\\fixtures\\users.json";


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        gson = new Gson();
    }

    @Test(priority = 1, description = "Inicio de sesión con usuario estandar")
    public void loginSession() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
