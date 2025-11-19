package testCases;

import Functions.NewtoursCommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

import static java.awt.SystemColor.text;

public class TC001_RegisterUserTestUpdated {

    WebDriver driver;

    @BeforeMethod
    public void OpenPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void TC001(){

        RegisterUser();
        VerifyRegistrationSuccess();

        // to enhance reusability

//        NewtoursCommonFunctions newtoursCommonFunctions = new NewtoursCommonFunctions(driver);
//        String actualText = newtoursCommonFunctions.RegisterUser("rose","david","abc@gmail.com","user123","pass123","pass123");
//        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");

    }

    public void RegisterUser(){

        HomePageUpdated homePageUpdated = new HomePageUpdated(driver);
        homePageUpdated.selectRegisterMenu();

        RegisterPageUpdated registerPage = new RegisterPageUpdated(driver);
        registerPage.setFirstName("lia");
        registerPage.setLastName("rose");
        registerPage.setEmail("test@gmail.com");
        registerPage.selectCountry();
        registerPage.SetUserName("user1");
        registerPage.SetPassword("pass123");
        registerPage.setConfirmPassword("pass123");
        registerPage.submit();
    }

    public void VerifyRegistrationSuccess(){

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccessText();   //output---->Dear
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");
    }


    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }
}
