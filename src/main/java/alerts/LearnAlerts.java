package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement seleniumPratice = driver.findElement(By.linkText("Selenium Practice"));
		Actions builder=new Actions(driver);
		builder.moveToElement(seleniumPratice).perform();
		
		driver.findElement(By.linkText("Alerts")).click();
		
		//Simple alert
		//In simple alert it has only one option
		WebElement simple = driver.findElement(By.xpath("//button[@id='alertBox']"));
		builder.moveToElement(simple).click().perform();
		//Alert is a interface
		//create an variable for the Alert
		Alert simpleAlert=driver.switchTo().alert();
		//get the text of alert box
		System.out.println(simpleAlert.getText());
		//accept the alert
		simpleAlert.accept();
		
		
		//Confirmation alert
		//It has two options -->one is positive(ok) and another is  negative(cancel)
		driver.findElement(By.id("confirmBox")).click();
		//create an variable for alert interface
		Alert confirmAlert=driver.switchTo().alert();
		//accept the alert-->ok
		confirmAlert.accept();
		//cancel the alert--->cancel
        //confirmAlert.dismiss();
		//print the outuput text
		System.out.println(driver.findElement(By.id("output")).getText());
		
		
		//prompt box.
		//It has textbox -->we are able to type something in the text box
		//it has two options -->accept and dismiss
		driver.findElement(By.id("promptBox")).click();
		Alert promptAlert=driver.switchTo().alert();
		promptAlert.sendKeys("Vinoqueen");
		promptAlert.accept();
		System.out.println(driver.findElement(By.id("output")).getText());
		
		

		

	}

}
