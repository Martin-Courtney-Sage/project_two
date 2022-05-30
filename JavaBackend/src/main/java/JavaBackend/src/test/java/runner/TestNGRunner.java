package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginMain;

// features - which features to use for the tests
// glue - 'glue code' is where the actual step implementation are.
@CucumberOptions(features = {"src/test/resources/Login.feature"}, glue={"steps"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static LoginMain loginMain;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/visio/OneDrive/Desktop/Revature/chromedriver.exe");

        driver = new ChromeDriver();
        loginMain = new LoginMain(driver);
    }

    @AfterSuite
    public void teardown(){
        driver.quit();
    }

}
