package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMain {

    WebDriver driver;

    public LoginMain(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement usernameField(){
        return driver.findElement(By.id("usernameInput"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.id("passwordInput"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.id("loginButton"));
    }

//    public void clickUsernameField(){
//        usernameField().click();
//    }
//
//    public void clickPasswordField(){
//        passwordField().click();
//    }


}
