package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class MainPage {
    WebDriver driver;
    WebElement burgerMenu;
    WebElement all_items;
    WebElement about;
    WebElement Logout;
    WebElement reset_app_state;
    boolean open;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    

    public MainPage(WebDriver driver) {
        if(driver == null){
            throw new NullPointerException("Driver can't be null for MainPage");
        }
        this.driver = driver;
        open = false;
    }
    
    public void clickBurgerMainn(){
        burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        System.out.println(open ? "Main Openned" : "Main Closed");
        open = !open;
    }
    
    public void clickAllItems(){
        all_items = driver.findElement(By.id("inventory_sidebar_link"));
        all_items.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    public void clickAbout(){
        about = driver.findElement(By.id("about_sidebar_link"));
        about.click();
        wait.until(ExpectedConditions.urlToBe("https://saucelabs.com/"));
        driver.findElement(By.xpath("//h1[contains(text(),'Build apps users love with AI-driven quality')]"));
    }
    
    public void clickLogout(){
        Logout = driver.findElement(By.id("logout_sidebar_link"));
        Logout.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com"));
        driver.findElement(By.xpath("//input[@type='submit' and contains(text(),'Login') and @id='login-button']"));
    }
    
    public void clickReset(){
        reset_app_state = driver.findElement(By.id("reset_sidebar_link"));
        reset_app_state.click();
    }

    public void addItemToCart(String itemName) {
        String source = driver.getCurrentUrl();
        if(!source.equals("https://www.saucedemo.com/inventory.html")){
            driver.get("https://www.saucedemo.com/inventory.html");
        }
        WebElement item = driver.findElement(By.xpath("//div[@Class='inventory_item_name ' and contains(text(),'"+itemName+"')]"));
        item.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("back-to-products"))));
        driver.findElement(By.id("add-to-cart")).click();
    }
}
