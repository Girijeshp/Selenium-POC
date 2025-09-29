package essPackage.pageObjects;

import essPackage.ApplicationHooks.BaseClass;
import essPackage.utils.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass extends BaseClass {

    UtilityClass utils;
    WebDriver driver;

    public LoginClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new UtilityClass(driver);
    }

    @FindBy(name = "email")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//span[contains(text(),'Submit')]")
    WebElement loginButton;


    public void userNameAndPassword() {

        String user = prop.getProperty("Username");
        String pass = prop.getProperty("Password");
        utils.WaitForElement(userName);
        userName.sendKeys(user);
        utils.WaitForElement(password);
        password.sendKeys(pass);
        System.out.println("Username: " + user + "\nPassword: " + pass);

    }

    public void clickLoginButton() {
        utils.WaitForElement(loginButton);
        loginButton.click();
    }


}
