package org.QATS.TestsLearning.DragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args){
        String url = "https://demoqa.com/droppable";

        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        // action.dragAndDrop(from,to).build().perform();

        // Usar coordenadas X y Y
        action.dragAndDropBy(from,330,36).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.quit();
    }
}
