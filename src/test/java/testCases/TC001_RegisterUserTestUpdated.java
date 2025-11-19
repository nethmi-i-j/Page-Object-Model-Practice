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

//        RegisterUser();
//        VerifyRegistrationSuccess();

        // to enhance reusability

        NewtoursCommonFunctions newtoursCommonFunctions = new NewtoursCommonFunctions(driver);
        String actualText = newtoursCommonFunctions.RegisterUser("rose","david","abc@gmail.com","user123","pass123","pass123");
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");

    }

    public void RegisterUser(){

        HomePageUpdated homePageUpdated = new HomePageUpdated(driver);
        homePageUpdated.selectRegisterMenu();
        //homePageUpdated.registerBtn.click();

        //driver.findElement(homePage.registerBtnLocator).click(); ---> another way

        RegisterPageUpdated registerPageUpdated = new RegisterPageUpdated(driver);
        registerPageUpdated.setFirstName("lia");
        registerPageUpdated.setLastName("rose");
        registerPageUpdated.setEmail("test@gmail.com");
        registerPageUpdated.selectCountry();
        registerPageUpdated.SetUserName("user1");
        registerPageUpdated.SetPassword("pass123");
        registerPageUpdated.setConfirmPassword("pass123");
        registerPageUpdated.submit();
    }

    public void VerifyRegistrationSuccess(){

        RegisterSuccessPageUpdated registerSuccessPageUpdated = new RegisterSuccessPageUpdated(driver);
        String actualText = registerSuccessPageUpdated.registerSuccessText();   //output---->Dear
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");

        /*to include testNG assertions into java class under the main folder
                   it should update the testNG dependency by deleting scope line*/
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }
}
