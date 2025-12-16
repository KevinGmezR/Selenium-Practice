package org.QATS.TestsLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        String url = "https://demoqa.com/dynamic-properties";

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Boton clickeado la cretaaaaaaaaaaaaaaa");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.quit();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
