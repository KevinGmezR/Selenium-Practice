package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    WebElement cart;
    boolean open;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    

    public MainPage(WebDriver driver) {
        this.driver = driver;
        burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        all_items = driver.findElement(By.id("inventory_sidebar_link"));
        about = driver.findElement(By.id("about_sidebar_link"));
        Logout = driver.findElement(By.id("logout_sidebar_link"));
        reset_app_state = driver.findElement(By.id("reset_sidebar_link"));
        cart = driver.findElement(By.xpath("//a[@Class='shopping_cart_link']"));
        open = false;
    }
    
    public void clickBurgerMainn(){
        burgerMenu.click();
        System.out.println(open ? "Main Openned" : "Main Closed");
        open = !open;
    }
    
    public void clickAllItems(){
        all_items.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
    }

    public void clickAbout(){
        about.click();
        wait.until(ExpectedConditions.urlToBe("https://saucelabs.com/"));
        driver.findElement(By.xpath("//h1[contains(text(),'Build apps users love with AI-driven quality')]"));
    }
    
    public void clickLogout(){
        Logout.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com"));
        driver.findElement(By.xpath("//input[@type='submit' and contains(text(),'Login') and @id='login-button']"));
    }
    
    public void clickReset(){
        reset_app_state.click();
    }

    public void clickCart(){
        cart.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        driver.findElement(By.id("checkout-btn"));
    }
}
