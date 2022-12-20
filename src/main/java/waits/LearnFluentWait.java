package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFluentWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/waits.xhtml;jsessionid=node0n20urdtnrq6919ix7ktg5wcvs400589.node0");
		
		driver.findElement(By.xpath("//span[@id='j_idt87:show']//span")).click();
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//FluentWait is used to tell the web driver to wait for a conditon as well as the frequency with 
		//which we want to check the condition before throwing an exception
		//By setting the frequency we are reducing the burden of default polling(500ms)-->0.5,1.0,1.0-->every time no need to search
		//By using pollingevery set the certain time 
		
		//Create an variable for Wait with WebDriver interface
		//create an object for FluentWait and pass the driver 
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				    //set the timeout 
			       .withTimeout(Duration.ofSeconds(20))
			       //Set the frequency
			       .pollingEvery(Duration.ofSeconds(3))
			       //Ignore the exception
			       .ignoring(NoSuchElementException.class);
		//check the conditions
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='I am here']"))));
		
		driver.findElement(By.xpath("//span[text()='I am here']")).click();

	}

}
