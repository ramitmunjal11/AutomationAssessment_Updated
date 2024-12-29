package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By email = By.id("email");
	By password = By.id("pass");
	By submitButton = By.id("send2");
	By getMyAccountMessage = By.xpath("//span[text()='My Account']");
	//By getMyAccountMessage = By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[1]/h1/span");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String email_input) {
		driver.findElement(email).sendKeys(email_input);
	}

	public void enterPassword(String password_input) {
		driver.findElement(password).sendKeys(password_input);
	}

	public void signIn() {
		driver.findElement(submitButton).click();
	}

	public String getMyAccountMessage() {
		return driver.findElement(getMyAccountMessage).getText();
	}

}
