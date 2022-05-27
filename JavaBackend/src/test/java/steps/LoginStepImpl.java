package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepImpl {

    public static WebDriver driver = new ChromeDriver();

    @Given("^The User is on Login Page$")
    public void the_User_is_on_Login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^The User provides correct user details for general user role and clicks Login button$")
    public void the_User_provides_correct_user_details_for_general_user_role_and_clicks_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^The User is sent to User Profile Page$")
    public void the_User_is_sent_to_User_Profile_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^The User provides correct user details for admin user role and clicks Login button$")
    public void the_User_provides_correct_user_details_for_admin_user_role_and_clicks_Login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^The User is sent to Admin Profile Page$")
    public void the_User_is_sent_to_Admin_Profile_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^The User provides incorrect user details$")
    public void the_User_provides_incorrect_user_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^The User is provided with alert\\.$")
    public void the_User_is_provided_with_alert() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

}
