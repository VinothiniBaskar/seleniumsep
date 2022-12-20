package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement makeUp = driver.findElement(By.xpath("//li[@class='MegaDropdownHeadingbox']//a[1]"));
		
		//Actions is a class
		//It is used to do mouse actions in the web page
		
		//create a object for Actions class and pass the driver in constructor
		Actions builder=new Actions(driver);
		//Use that object and call the required methods
		//perform method is mandatory
		builder.moveToElement(makeUp).perform();
		

		WebElement mascara = driver.findElement(By.xpath("//a[text()='Mascara']"));
		builder.moveToElement(mascara).click().perform();
		

		
		
		
		
	}

}
