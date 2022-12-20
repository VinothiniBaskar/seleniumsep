package attributes;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authentication {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://leafground.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(By.xpath("//i[contains(@class,'pi pi-home layout-menuitem-icon')]")).click();
	        
			driver.findElement(By.xpath("//span[text()='Auth']")).click();
			
		     driver.findElement(By.xpath("//span[contains(@class,'ui-button-text ui-c')]")).click();
		     Alert alert=driver.switchTo().alert();
		     alert.sendKeys("admin");
		     alert.sendKeys("testleaf");
		     alert.accept();
			
			
			
	}
	
}
