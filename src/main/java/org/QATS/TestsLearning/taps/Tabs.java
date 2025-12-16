package org.QATS.TestsLearning.taps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Tabs {

    private String url = "https://demoqa.com/links";

    WebDriver driver;

    @BeforeMethod
    public void setBaseUrl(){
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(priority = 1)
    public void openNewTabUsingJS() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void openNewTabClicking() throws InterruptedException {
        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("dynamicLink")).click();
        Thread.sleep(5000);

        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void handleTabs()  throws InterruptedException {
        String mainTab = driver.getWindowHandle();
        String newTab = "";

        System.out.println("Main Tab: " + mainTab);
        driver.findElement(By.id("simpleLink")).click();
        Thread.sleep(5000);

        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            System.out.println("Handle ID: " + handle);

            if(!handle.equalsIgnoreCase(mainTab)){
                System.out.println("Changing Tab");
                driver.switchTo().window(handle);
                newTab = handle;
            }
        }

        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void closeBrowser(){ driver.quit(); }
}
