
package JavaFoldersnextstep5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps5 {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String LOGIN_URL =
            "https://admin-demo.nopcommerce.com/";

    private static final Duration TIMEOUT =
            Duration.ofSeconds(20);

    // Page element locators
    private static final By EMAIL_FIELD = By.id("Email");
    private static final By PASSWORD_FIELD = By.id("Password");
    private static final By LOGIN_BUTTON =
            By.cssSelector("button.login-button");

    // Expected element after successful login
    private static final By LOGOUT_LINK =
            By.cssSelector("a[href='/logout']");

    @Given("^User is navigating to the page$")
    public void user_is_navigating_to_the_page() {

        ChromeOptions options = new ChromeOptions();

        // Configure Chrome for GitHub Actions
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, TIMEOUT);

        driver.get(LOGIN_URL);
    }

    @When("^User is adding Email and Password$")
    public void user_is_adding_Email_and_Password() {

        String email = System.getenv("TEST_EMAIL");
        String password = System.getenv("TEST_PASSWORD");

        if (email == null || email.isBlank()
                || password == null || password.isBlank()) {

            throw new IllegalStateException(
                "TEST_EMAIL and TEST_PASSWORD must be configured."
            );
        }

        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                EMAIL_FIELD
            )
        );

        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                PASSWORD_FIELD
            )
        );

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("^User is clicking on Login button$")
    public void user_is_clicking_on_Login_button() {

        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                LOGIN_BUTTON
            )
        );

        loginButton.click();
    }

    @Then("^User is logged into Admin Applications$")
    public void user_is_logged_into_Admin_Application() {

        WebElement logoutLink = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                LOGOUT_LINK
            )
        );

        if (!logoutLink.isDisplayed()) {
            throw new AssertionError(
                "Login verification failed: logout link not visible."
            );
        }
    }

    @After
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
