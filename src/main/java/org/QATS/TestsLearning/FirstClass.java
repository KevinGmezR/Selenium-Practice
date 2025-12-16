package org.QATS.TestsLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kevin@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Contraseña']")).sendKeys("Kevin2212Pass");

    }
}
