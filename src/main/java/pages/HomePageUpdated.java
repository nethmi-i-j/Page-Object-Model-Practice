package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageUpdated {

    WebDriver driver;

    public HomePageUpdated(WebDriver driver){// constructor
        this.driver = driver;
        PageFactory.initElements(driver,this);   // Element identification using PageFactory class
    }

    // Element identification

    @FindBy(linkText = "REGISTER")
    public WebElement registerBtn;

    @FindBy(linkText = "SIGN-ON")
    public WebElement loginBtn;

    /* Another way
       @FindBy(how = How.LINK_TEXT, using ="REGISTER")
       public WebElement registerBtn;
    */

    public void selectRegisterMenu(){
        registerBtn.click();
    }

    public void selectLoginMenu(){
        loginBtn.click();
    }




}
