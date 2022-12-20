package actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollElement {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement scroll = driver.findElement(By.xpath("//div[text()='Make Money with Us']"));
		Actions builder=new Actions(driver);
		builder.scrollToElement(scroll).perform();
		String text=scroll.getText();
		System.out.println(text);
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Snaps.scroll.png");
		FileUtils.copyFile(source, destination);
		
	}

}
