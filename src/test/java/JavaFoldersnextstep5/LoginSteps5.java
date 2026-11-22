
package JavaFoldersnextstep5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps5 {

    static WebDriver driver;

    @Given("^User is navigating to the page$")
    public void user_is_navigating_to_the_page() {

        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/");
    }

    @When("^User is adding Email and Password$")
    public void user_is_adding_Email_and_Password() {

        String email = System.getenv("TEST_EMAIL");
        String password = System.getenv("TEST_PASSWORD");

        if (email == null || password == null) {
            throw new IllegalStateException(
                "TEST_EMAIL and TEST_PASSWORD must be configured."
            );
        }

        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("^User is clicking on Login button$")
    public void user_is_clicking_on_Login_button() {

        WebElement login = driver.findElement(
            By.cssSelector("button.login-button")
        );

        login.click();
    }

    @Then("^User is logged into Admin Applications$")
    public void user_is_logged_into_Admin_Application() {

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(15)
        );

        WebElement logout = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[href='/logout']")
            )
        );

        assertTrue(
            "Login failed: Logout link not visible",
            logout.isDisplayed()
        );
    }

    @After
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
