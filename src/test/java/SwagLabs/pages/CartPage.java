package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    String url;
    WebDriver driver;
    WebElement continue_shopping;
    WebElement checkout;
    WebDriverWait wait;
    WebElement continue_checkout;
    WebElement cancel_continue_step2;
    WebElement finish;

    public CartPage(WebDriver driver) {
        if(driver == null) {
            throw new NullPointerException("Driver can't be null for CartPage");
        }
        url = "https://www.saucedemo.com/cart.html";
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goTo(){
        driver.get(url);
        continue_shopping = driver.findElement(By.id("continue-shopping"));
        checkout = driver.findElement(By.id("checkout"));
    }

    public void clickContinueShoppingButton() {
        continue_shopping.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void clickCheckoutButton() {
        checkout.click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
        driver.findElement(By.xpath("//*[contains(text(),'Checkout: Your Information')]"));
        continue_checkout = driver.findElement(By.id("continue"));
    }

    public void clickContinueCheckoutButton(String FirstName, String LastName, String zip) {
        if(FirstName.isEmpty() || LastName.isEmpty() || zip.isEmpty()) {
            throw new RuntimeException("FirstName or LastName or zip is empty");
        }else{
            WebElement firstNameInput = driver.findElement(By.id("first-name"));
            WebElement lastNameInput = driver.findElement(By.id("last-name"));
            WebElement zipInput = driver.findElement(By.id("postal-code"));

            firstNameInput.sendKeys(FirstName);
            lastNameInput.sendKeys(LastName);
            zipInput.sendKeys(zip);
        }

        if(continue_checkout != null) {
            continue_checkout.click();
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));
            driver.findElement(By.xpath("//div[contains(text(),'Payment Information:')]"));
            cancel_continue_step2 = driver.findElement(By.id("cancel"));
            finish = driver.findElement(By.id("finish"));
        }else{
            throw new NullPointerException("Continue checkout button is not present");
        }
    }

    public void clickCancelContinueStep2() {
        if(cancel_continue_step2 != null) {
            cancel_continue_step2.click();
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        }else{
            throw new NullPointerException("Continue step2 is not present");
        }
    }

    public void clickFinishButton() {
        if(finish != null) {
            finish.click();
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
            driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).isDisplayed();
            driver.findElement(By.id("back-to-products")).click();
        }else {
            throw new NullPointerException("Finish button is not present");
        }
    }

    public void comprobateProductInCart(String productName) {
       String url = driver.getCurrentUrl();
       if(!url.equals("https://www.saucedemo.com/cart.html")) {
           driver.get("https://www.saucedemo.com/cart.html");
       }
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@Class='inventory_item_name']")));
       WebElement element = driver.findElement(By.xpath("//*[@Class='inventory_item_name' and contains(text(),'" + productName + "')]"));
    }

}
