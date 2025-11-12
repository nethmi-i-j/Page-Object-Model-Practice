package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LoginSuccessPage;

import java.time.Duration;

public class TC002_LoginUserTest {

    WebDriver driver;

    @BeforeMethod
    public void OpenPage(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/index.php");
    }

    @Test
    public void TC002(){

        HomePage homePage = new HomePage(driver);
        homePage.selectLoginMenu();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("user1");
        loginPage.setPassword("pass123");
        loginPage.clickSubmitBtn();

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String actualText =  loginSuccessPage.loginSuccessText();
        Assert.assertTrue(actualText.contains("Thank"),"Login attempt failed");

    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }




}
