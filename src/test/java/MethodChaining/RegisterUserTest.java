package MethodChaining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageUpdated;

import java.time.Duration;

public class RegisterUserTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void tests(){

        HomePageUpdated homePageUpdated = new HomePageUpdated(driver);

        String actualText = homePageUpdated.selectRegisterMenu()
                .setFirstName("lia")
                .setLastName("rose")
                .setEmail("test@gmail.com")
                .selectCountry()
                .SetUserName("user1")
                .SetPassword("pass123")
                .setConfirmPassword("pass123")
                .submit()
                .registerSuccessText();
        Assert.assertTrue(actualText.contains("Dear"),"Registration attempt failed");
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }

}
