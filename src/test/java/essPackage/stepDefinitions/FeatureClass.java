package essPackage.stepDefinitions;

import essPackage.ApplicationHooks.BaseClass;
import essPackage.ApplicationHooks.Hooks;
import essPackage.pageObjects.LoginClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class FeatureClass extends BaseClass {
    // Scenario: Login to ESS.
    // Given User is on the ESS login page.
    // When User enters valid username and password.
    // And User clicks on the login button.
    // Then User should be redirected to the ESS dashboard.
    LoginClass login;
    @Given("User is on the ESS login page")
    public void user_is_on_the_ess_login_page() throws IOException {
       //1.call the setup method from the BaseClass to initialize the WebDriver and navigate to the ESS login page.
        System.out.println("Title of the page"+ Hooks.driver.getTitle());
    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        //1. get the username from excel sheet.
        //2. get the password from excel sheet.
        //3. enter the username in the username field.
        //4. enter the password in the password field.
        //5. print the username and password in the console.
         login = new LoginClass(driver);
         login.userNameAndPassword();

    }
    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        //1.locate the login button.
        //2.click on the login button.
       login.clickLoginButton();
    }

}
