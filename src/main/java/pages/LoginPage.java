package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }


    By userName_loc = By.name("userName");
    By password_loc = By.name("password");
    By submitBtn_loc = By.name("submit");

    public void setUserName(String userName){
        driver.findElement(userName_loc).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(password_loc).sendKeys(password);
    }

    public void clickSubmitBtn(){
        driver.findElement(submitBtn_loc).click();
    }

}
