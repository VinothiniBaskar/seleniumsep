package attributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns{

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Without select
		driver.findElement(By.xpath("//div[@class=' css-1wy0on6']//div[1]")).click();
		driver.findElement(By.id("react-select-2-option-0-1")).click();
		
		driver.findElement(By.xpath("//div[text()='Select Title']")).click();
		
		driver.findElement(By.xpath("//div[text()='Ms.']")).click();
		
		
		//With select
		WebElement element = driver.findElement(By.id("oldSelectMenu"));
//		Select s=new Select(element);
//		s.selectByValue("red");
//		Select s1=new Select(element);
//		s1.selectByIndex(5);
		Select s2=new Select(element);
		s2.selectByVisibleText("Red");
		//Verify the selected value in the dropdown
		System.out.println(s2.getFirstSelectedOption().getText());
		
		//Multiselect option and print
		
		driver.findElement(By.xpath("//div[text()='Select...']")).click();
		driver.findElement(By.id("react-select-4-option-0")).click();
		driver.findElement(By.id("react-select-4-option-2")).click();
		driver.findElement(By.id("react-select-4-option-3")).click();
		
		
		
	}

}
