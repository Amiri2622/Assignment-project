package JavaFoldersnextstep5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps5 {
	static WebDriver driver;

	@Given("^User is navigating to the page$")
	public void user_is_navigating_to_the_page() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/");
	}

	@When("^User is adding Email and Password$")
	public void user_is_adding_Email_and_Password() throws Throwable {

		WebElement Email = driver.findElement(By.id("Email"));
		Email.clear();
		Email.sendKeys("admin@yourstore.com");

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("admin");

	}
	@And("^User is clicking on Login button$")
	public void user_is_clicking_on_Login_button() throws Throwable {
		WebElement login = driver.findElement(By.xpath("//button[@class=\\\"button-1 login-button\\\"]"));
		login.click();
	}

	@Then("^User is logged into Admin Application$")
	public void user_is_logged_into_Admin_Application() throws Throwable {
		System.out.println("The project has successfully passed");
	}

}
