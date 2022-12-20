package frame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/frames");
		// driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Iframe
		driver.findElement(By.linkText("iFrame")).click();
		driver.switchTo().frame("mce_0_ifr");
		WebElement message=driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
		message	.clear();
		message.sendKeys("Hi Queen");
		driver.navigate().back();

//		List<WebElement> frames = driver.findElements(By.tagName("frame"));
//		int size=frames.size();
//		System.out.println("The size of the frames is :"+size);

		//Nested frames
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-bottom");
		String bottomFrame = driver.findElement(By.tagName("body")).getText();
		System.out.println("The Bottom frame text is :"+bottomFrame);
		
		//left frame
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		String leftFrame = driver.findElement(By.tagName("body")).getText();
		System.out.println("The Left frame text is :"+leftFrame);

		//middle frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		String middleFrame = driver.findElement(By.id("content")).getText();
		System.out.println("The Middle frame text is :"+middleFrame);
		
		//right frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		String rightFrame = driver.findElement(By.tagName("body")).getText();
		System.out.println("The Right frame text is :"+rightFrame);
		driver.switchTo().defaultContent();
		driver.navigate().back();

		System.out.println("The Title is :"+driver.getTitle());
		String actualTitle="The Internet";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		

		// driver.close();

	}

}
