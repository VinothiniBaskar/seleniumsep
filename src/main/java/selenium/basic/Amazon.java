package selenium.basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@id='nav-main']//span")).click();
		driver.findElement(By.xpath("//div[text()='see all']")).click();
		driver.findElement(By.xpath("//ul[@class='hmenu-compress-section']//li[7]")).click();
		driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li[5]")).click();
		driver.findElement(By.xpath("//img[@data-image-index='4']")).click();
		String text = driver.findElement(By.xpath("//span[text()='$6.99']/following-sibling::span")).getText();
		System.out.println("The price is :"+text);
		String str=text.replaceAll("[^0-9]", "");
		System.out.println("The price is :"+str);

	}

}
