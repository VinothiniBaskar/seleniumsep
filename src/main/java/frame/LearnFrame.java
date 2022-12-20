package frame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         //Frame is a HTML element  that helps the developers organize the set of elements
		//iframe index starts with 0
		// find the frame using xpath
		WebElement frame = driver.findElement(By.xpath("//div[@class='card']//iframe"));
		// switch to frame
		driver.switchTo().frame(frame);
		// click the button -->It is there in the iframe tag
		driver.findElement(By.id("Click")).click();

		// Count the frames
		// come out of the iframe tag
		driver.switchTo().defaultContent();
		// find the WebElements
		List<WebElement> countFrames = driver.findElements(By.tagName("iframe"));
		// declare the size and use the method to find the size of the frame tags
		int size = countFrames.size();
		// Print the frames tags--->Index is starts from 0,1,2,3 -->Total is 4 -->Ans is
		// 3
		System.out.println("The size of the frame is :" + size);

		// Nested frames
		// A frame within the frame
		// Parent frame -->Child frame -->button
		//Move to the 1st frame-->Parent frame
		driver.switchTo().frame(2);
		//Move to the 2nd frame -->child frame
		driver.switchTo().frame("frame2");
		//Find the button -->within the child frame
		WebElement button=driver.findElement(By.xpath("//button[text()='Click Me']"));
		button.click();
		//Get the text 
		String text=button.getText();
		System.out.println("The Text of the button is :"+text);
		System.out.println(driver.getTitle());
		String actaulTitle="Frame";
		String title=driver.getTitle();
		//1st-->found  2nd-->Expected
		//Verify the title
		Assert.assertEquals(actaulTitle, title);
		driver.switchTo().defaultContent();

	}

}
