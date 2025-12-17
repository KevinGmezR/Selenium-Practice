package SwagLabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    private String baseUrl;

    public LoginPage(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        this.baseUrl = "https://www.saucedemo.com/";
        this.driver = driver;
    }

    public void goTo(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void login(String username, String password) {
        String currentURL = driver.getCurrentUrl();

        if (!currentURL.equals(baseUrl)) {
            driver.get(baseUrl);
        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));


        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);


        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        WebElement head = driver.findElement(By.xpath("//*[contains(text(),'Swag Labs')]"));
    }
}
