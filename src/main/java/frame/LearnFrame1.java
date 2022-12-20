package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement selenium = driver.findElement(By.linkText("Selenium Practice"));
		Actions builder=new Actions(driver);
		builder.moveToElement(selenium).perform();
		
		driver.findElement(By.linkText("Frames Practice")).click();
		
		driver.switchTo().frame("frm1");
		WebElement course = driver.findElement(By.id("course"));
		course.click();
		Select s=new Select(course);
		s.selectByVisibleText("Java");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frm2");
		WebElement control = driver.findElement(By.id("selectnav1"));
		control.click();
		Select s1=new Select(control);
		s1.selectByVisibleText("-- Automation Testing");
		
		


		
	}

}
