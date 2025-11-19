package Functions;

import org.openqa.selenium.WebDriver;
import pages.HomePageUpdated;
import pages.RegisterPageUpdated;
import pages.RegisterSuccessPageUpdated;

public class NewtoursCommonFunctions {

    WebDriver driver;

    public NewtoursCommonFunctions(WebDriver driver){
        this.driver = driver;

    }

    public String RegisterUser(String fName, String lName, String email, String uName, String pass, String confirmPass){

        HomePageUpdated homePageUpdated = new HomePageUpdated(driver);
        homePageUpdated.selectRegisterMenu();

        RegisterPageUpdated registerPageUpdated = new RegisterPageUpdated(driver);
        registerPageUpdated.setFirstName(fName);
        registerPageUpdated.setLastName(lName);
        registerPageUpdated.setEmail(email);
        registerPageUpdated.selectCountry();
        registerPageUpdated.SetUserName(uName);
        registerPageUpdated.SetPassword(pass);
        registerPageUpdated.setConfirmPassword(confirmPass);
        registerPageUpdated.submit();

        RegisterSuccessPageUpdated registerSuccessPageUpdated = new RegisterSuccessPageUpdated(driver);
        String successText = registerSuccessPageUpdated.registerSuccessText();   //output---->Dear
        return successText;
    }


}
