package string.methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("women",Keys.ENTER);
		driver.findElement(By.xpath(
				"//label[@class='facet-linkname facet-linkname-l1l3nestedcategory facet-linkname-Women - Sarees']"))
				.click();
		driver.findElement(By.xpath("//div[@class='filter-dropdown']")).click();
	    WebElement dropdown=driver.findElement(By.xpath("//div[@class='filter-dropdown']//select"));
		Select sec=new Select(dropdown);
		sec.selectByVisibleText("What's New");
		
		
		String items = driver.findElement(By.xpath("//div[@class='filter']//div")).getText();
		System.out.println(items);
		// It removes the number and get the text only
		System.out.println(items.replaceAll("[^a-zA-Z]","" ));

	}
	}


