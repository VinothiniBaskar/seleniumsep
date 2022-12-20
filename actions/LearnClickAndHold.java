package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnClickAndHold {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/drag.xhtml;jsessionid=node0dlco7ypcvm6r106yyp5tr3xzs434481.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement black = driver.findElement(By.xpath("(//td[text()='Bamboo Watch'])[2]"));
		
		WebElement blue =  driver.findElement(By.xpath("(//td[text()='Bracelet'])[2]"));
		
		Actions builder=new Actions(driver);
		builder.clickAndHold(black).moveToElement(blue).perform();

	}

}
