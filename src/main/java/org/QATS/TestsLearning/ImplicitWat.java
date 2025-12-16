package org.QATS.TestsLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ImplicitWat {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        String url = "https://demoqa.com/dynamic-properties";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        try{
            WebElement button = driver.findElement(By.id("visibleAfter"));
            System.out.println("Boton clickeado la cretaaaaaaaaaaaaaaa");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.quit();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
