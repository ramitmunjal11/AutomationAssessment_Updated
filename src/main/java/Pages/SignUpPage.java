package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

	WebDriver driver;

	By fName = By.id("firstname");
	By lName = By.id("lastname");
	By email = By.id("email_address");
	By Password = By.id("password");
	By confirmPassword = By.id("password-confirmation");
	By createAccountButton = By.xpath("//button[@title='Create an Account']");
	By successMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
																											
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFirstName(String firstName) {
		driver.findElement(fName).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lName).sendKeys(lastName);
	}

	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}

	public void enterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		driver.findElement(confirmPassword).sendKeys(password);
	}

	public void clickCreateAccount() {
		driver.findElement(createAccountButton).click();
	}

	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}

}
