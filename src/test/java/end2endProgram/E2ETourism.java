package end2endProgram;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class E2ETourism {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://nichethyself.com/tourism/home.html");
		driver.findElement(By.xpath("//a[@href='customised.html']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		String firstWindow = driver.getWindowHandle(); // storing first window ID
		String secondWindow = null;

		// Switch to the new window
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				secondWindow = windowHandle; // storing second window ID
				break;
			}
		}

		WebElement my_dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(my_dropdown);
		dropdown.selectByVisibleText("Home Stay");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='England']/input")));
		driver.findElement(By.xpath("//label[text()='England']/input")).click();

		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		String popupWindow = null;
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(firstWindow) && !windowHandle.equals(secondWindow)) {
				driver.switchTo().window(windowHandle);
				popupWindow = windowHandle;
			}
		}
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/span")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_L); // l
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_O); // o
		robot.keyPress(KeyEvent.VK_N); // n
		robot.keyPress(KeyEvent.VK_D); // d
		robot.keyPress(KeyEvent.VK_O); // o
		robot.keyPress(KeyEvent.VK_N); // n
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(1000);
		driver.close();

		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
