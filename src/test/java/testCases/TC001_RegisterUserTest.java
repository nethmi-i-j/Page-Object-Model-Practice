package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;

import java.time.Duration;

public class TC001_RegisterUserTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("");
    }

    @Test
    public void TC001(){

        HomePage homePage = new HomePage(driver);
        homePage.selectRegisterMenu();

        //driver.findElement(homePage.registerBtnLocator).click(); ---> another way

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName("lia");
        registerPage.setLastName("rose");
        registerPage.setEmail("test@gmail.com");
        registerPage.selectCountry();
        registerPage.SetUserName("user1");
        registerPage.SetPassword("pass123");
        registerPage.setConfirmPassword("pass123");
        registerPage.submit();

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccessText();   //output---->Dear
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");

        /*to include testNG assertions into java class under the main folder
                   it should update the testNG dependency by deleting scope line*/

    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }
}
