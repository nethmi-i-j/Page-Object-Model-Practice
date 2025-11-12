package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccessPage {

    WebDriver driver;

    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;

    }

    By successText_loc = By.xpath("//b[contains(text(),'Thank')]");

    public String loginSuccessText(){
        String successText = driver.findElement(successText_loc).getText();
        return successText;
    }


}
