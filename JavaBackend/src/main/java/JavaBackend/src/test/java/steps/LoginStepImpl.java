package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginMain;
import runner.TestNGRunner;

public class LoginStepImpl {

    public static WebDriver driver = TestNGRunner.driver;
    public static LoginMain loginMain = TestNGRunner.loginMain;

    @Given("^The User is on Login Page$")
    public void the_User_is_on_Login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("file:///C:/Users/visio/OneDrive/Documents/GitHub/project_two/Project2_Frontend/proj2Login.html");
    }

    @When("^The User provides correct user details for general user role and clicks Login button$")
    public void the_User_provides_correct_user_details_for_general_user_role_and_clicks_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement username = loginMain.usernameField();
        WebElement password = loginMain.passwordField();
        WebElement loginButton = loginMain.loginButton();

        username.sendKeys("test202");
        password.sendKeys("pass1234");
        loginButton.click();
    }

    @Then("^The User is sent to User Profile Page$")
    public void the_User_is_sent_to_User_Profile_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "User Profile");
    }

    @When("^The User provides correct user details for admin user role and clicks Login button$")
    public void the_User_provides_correct_user_details_for_admin_user_role_and_clicks_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement username = loginMain.usernameField();
        WebElement password = loginMain.passwordField();
        WebElement loginButton = loginMain.loginButton();

        username.sendKeys("test101");
        password.sendKeys("pass1234");
        loginButton.click();
    }

    @Then("^The User is sent to Admin Profile Page$")
    public void the_User_is_sent_to_Admin_Profile_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Admin Profile");
    }

    @When("^The User provides incorrect user details$")
    public void the_User_provides_incorrect_user_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement username = loginMain.usernameField();
        WebElement password = loginMain.passwordField();
        WebElement loginButton = loginMain.loginButton();

        username.sendKeys("incorrect_username");
        password.sendKeys("incorrect_password");
        loginButton.click();
    }

    @Then("^The User is provided with alert\\.$")
    public void the_User_is_provided_with_alert() throws Throwable {
        driver.switchTo().alert().dismiss();
    }

}
