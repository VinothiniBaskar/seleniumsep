package advanced.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SiblingXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//find by younger-->label--Elder and input --Younger
		//source -->elder and destination--->younger
		//Write the xpath for elder and following::younger tag name
		driver.findElement(By.xpath("//label[text()='Username']/following::input")).sendKeys("Demosalesmanager");
		
		//find by elder-->label--Elder and input --Younger
		//source -->younger and destination--->elder
		//Write the xpath for younger and preceding::elder tag name
		//input[@id='password']/preceding::label[1]
		
		//Find by elder cousin
		//Write the xpath for younger and peceding younger tag name 
		//If many cousins are there using index we can find the exact elder cousin
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']/preceding::input[1]")).sendKeys("crmsfa");
		
		//Find by younger cousin
		//Write the xpath for elder and following younger tag name 
		//If many cousins are there using index we can find the exact younger cousin
		driver.findElement(By.xpath("//label[text()='Username']//following::input[3]")).click();
		
		
		
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

}
