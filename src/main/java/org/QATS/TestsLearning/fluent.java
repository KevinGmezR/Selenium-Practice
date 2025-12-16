package org.QATS.TestsLearning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;


import java.time.Duration;
import java.util.function.Function;

public class fluent<W extends SearchContext> {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        String url = "https://demoqa.com/dynamic-properties";

        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(20))
                .ignoring(NoSuchElementException.class);


        driver.get(url);
        driver.manage().window().maximize();

        try{
            WebElement button = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver webDriver) {
                    return driver.findElement(By.id("visibleAfter"));
                }
            });
            button.click();
            System.out.println("Boton clickeado la cretaaaaaaaaaaaaaaa");
            driver.quit();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
