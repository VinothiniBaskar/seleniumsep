package actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		WebElement rc = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions builder=new Actions(driver);
		
		//contextClick is used to right click the element
		builder.contextClick(rc).perform();
		
		WebElement quit = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-quit']"));
		quit.click();
		
		//Alert is a interface
		Alert alert = driver.switchTo().alert();
		//accept the alert
		alert.accept();
		
		//print the title
		System.out.println("The Title is :"+driver.getTitle());
		
	}

}
