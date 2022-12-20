package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDraggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Find the element
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		// switch to frame
		driver.switchTo().frame(frame);

		// find the element
		WebElement drag = driver.findElement(By.id("draggable"));

		// get the location
		Point location = drag.getLocation();
		int x = location.getX();
		int y = location.getY();

		// use Actions class
		Actions builder = new Actions(driver);

		// one way --->using x and y
		builder.dragAndDropBy(drag, x, y).perform();

		// 2nd way-->userdefined values for the axes
//		builder.dragAndDropBy(drag, 100, 130).perform();

	}

}
