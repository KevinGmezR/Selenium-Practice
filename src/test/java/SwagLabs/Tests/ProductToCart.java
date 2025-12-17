package SwagLabs.Tests;

import SwagLabs.Entities.User;
import SwagLabs.pages.CartPage;
import SwagLabs.pages.LoginPage;
import SwagLabs.pages.MainPage;
import com.google.gson.Gson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class ProductToCart {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    List<User> users;

    @BeforeMethod
    public void beforeMethod()  {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");

        try{
            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            loginPage = new LoginPage(driver);
            mainPage = new MainPage(driver);
            cartPage = new CartPage(driver);
            users = LoadUsers();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Test(priority = 1, description = "Producto añadido exitosamente")
    public void productToCart(){
        loginPage.login(users.getFirst().getUsername(), "secret_sauce");
        mainPage.addItemToCart("Sauce Labs Backpack");
        driver.findElement(By.xpath("//span[@Class='shopping_cart_badge']")).isDisplayed();
        cartPage.goTo();
        cartPage.comprobateProductInCart("Sauce Labs Backpack");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    public List<User> LoadUsers() throws FileNotFoundException {
        Gson gson = new Gson();
        Type typeList = new TypeToken<List<User>>(){}.getType();
        return gson.fromJson(new FileReader("src/test/java/SwagLabs/fixtures/users.json"),typeList);
    }

}



