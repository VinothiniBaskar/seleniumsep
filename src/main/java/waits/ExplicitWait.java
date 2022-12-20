package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/waits.xhtml");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Explicit wait is selenium wait
		//Explict wait is used to wait for behaviour of the element in the DOM
		//It allows us to command the web driver to wait until the several conditions are met.
		//excepted condtions are met it will perform the action,otherwisse throw the TimeOutException
		
		
		
		//Create an object for WebDriverWait and pass the arguments as driver and time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement visible = driver.findElement(By.xpath("//span[@id='j_idt87:show']//span"));
		try {

			visible.click();
		} catch (Exception e) {
			//Use that object and use until ,ExceptedConditons.which method want to use
			wait.until(ExpectedConditions.visibilityOf(visible));
		}

		driver.findElement(By.xpath("//span[text()='I am here']")).click();

		WebElement inVisible = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt92']//span"));
		try {
			inVisible.click();

		} catch (Exception e) {
			wait.until(ExpectedConditions.invisibilityOf(inVisible));
		}

		WebElement clickable = driver.findElement(By.xpath("//span[text()='Click First Button']"));

		try {
			clickable.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(clickable));
		}

		WebElement textChange = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt98']//span"));
		Actions builder = new Actions(driver);
		try {
			builder.moveToElement(textChange).click().perform();

		} catch (Exception e) {
			wait.until(ExpectedConditions.textToBePresentInElement(textChange, "Did you notice?"));

		}
	}
}
