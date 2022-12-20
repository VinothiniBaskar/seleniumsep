package advanced.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		//Parent to child -->p -parent and input- child
		//Write the xpath of parent and followed by child tag name
		//tagName[@attributeName='attributevalue']//child tag name
		driver.findElement(By.xpath("//p[@class='top']//input")).sendKeys("Democsr2");
		
		//Grand parent to Grand child
		//Write the xpath of Grand parent and followed by Grand child tag name
		//tagName[@attributeName='attributevalue']//Grand child tag name
		driver.findElement(By.xpath("//form[@id='login']//p[2]//input")).sendKeys("crmsfa");
		
		//Partial text based xpath
		//tagName[contains(@attributeName,'attributevalue')]
		driver.findElement(By.xpath("//input[contains(@class,'decorativeSubmit')]")).click();
		
		//using linktext
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		WebElement prospects = driver.findElement(By.xpath("//ul[contains(@class,'sectionTabBar')]//li[2]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(prospects).click().perform();
		
		driver.findElement(By.xpath("//ul[@class='shortcuts']//li[2]")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vinothini");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");

		
		WebElement source = driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
		source.click();
		Select s=new Select(source);
		s.selectByValue("LEAD_EMPLOYEE");
		
		WebElement industry=driver.findElement(By.xpath("//select[@id='createLeadForm_industryEnumId']"));
		industry.click();
		Select s1=new Select(industry);
		s1.selectByVisibleText("Finance");
		
		
		
		driver.findElement(By.xpath("//input[@value='Créer un prospect']")).click();
		

	}

}
