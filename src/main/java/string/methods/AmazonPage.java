package string.methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplusPro",Keys.ENTER);
		WebElement oneplus=driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		oneplus.click();
		String price=oneplus.getText();
		System.out.println(driver.getTitle());
		System.out.println(price);
		//only number is printed in console for removing symbol 
		String str=price.replaceAll("[^0-9]", "");
		System.out.println(str);
		
		
	}
}
