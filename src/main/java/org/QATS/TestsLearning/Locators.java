package org.QATS.TestsLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        String username = "standard_user";
        String password = "secret_sauce";

        driver.get("https://www.saucedemo.com/");

        //Locators By ID
        WebElement userInput = driver.findElement(By.id("user-name"));
        WebElement passInput = driver.findElement(By.id("password"));

        userInput.sendKeys(username);
        passInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        // Locator by ClassName
        loginButton = driver.findElement(By.className("submit-button"));

        //Locator by Name
        loginButton = driver.findElement(By.name("login-button"));

        //Locator by Xpath
        loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));

        //Locator by CSS
        loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
    }
}
