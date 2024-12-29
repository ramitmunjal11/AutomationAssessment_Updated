package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.LoginPage;
import Pages.SignUpPage;
import Resources.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {

	WebDriver driver = DriverManager.getDriver();
	SignUpPage signUpPage = new SignUpPage(driver);
	LoginPage loginPage = new LoginPage(driver);

	static int num = (int) (Math.random() * (500000));
	String email_new = num + "@email.com";

	@Given("I am on the sign-up page")
	public void i_am_on_the_sign_up_page() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
	}

	@When("I enter valid details {string} {string} email {string} {string}")
	public void i_enter_valid_details(String firstName, String lastName, String password, String confirmPassword) {
		signUpPage.enterFirstName(firstName);
		signUpPage.enterLastName(lastName);
		signUpPage.enterEmail(email_new);
		signUpPage.enterPassword(password);
		signUpPage.enterConfirmPassword(confirmPassword);
	}

	@And("I click on Create an Account")
	public void i_click_on_create_account() {
		signUpPage.clickCreateAccount();
	}

	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
		Assert.assertEquals("Thank you for registering with Main Website Store.", signUpPage.getSuccessMessage());
		driver.quit();
	}

	@Given("I am on login page")
	public void i_am_on_login_page() {
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/");
	}

	@When("I enter email and {string} and click submit")
	public void i_enter_and_and_click_submit(String string2) {
		loginPage.enterEmail(email_new);
		loginPage.enterPassword(string2);
		loginPage.signIn();
	}

	@Then("I should able to login")
	public void i_should_able_to_login() {
		String message = loginPage.getMyAccountMessage();
		Assert.assertEquals(message, "My Account");
		driver.quit();
	}

}
