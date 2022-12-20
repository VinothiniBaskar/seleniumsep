package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		driver.switchTo().frame("frame1");
//		String text = driver.findElement(By.id("sampleHeading")).getText();
//		System.out.println("The text is :" + text);
//		driver.switchTo().defaultContent();
//
//		driver.switchTo().frame("frame2");
//		String text1 = driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText();
//		System.out.println("The text1 is :" + text1);
//		driver.switchTo().defaultContent();

		WebElement nestedFrame = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(nestedFrame).click().perform();

		driver.switchTo().frame("frame1");
		Thread.sleep(3000);
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(frame1);
		String text2 = driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText();
		System.out.println("The text2 is :" + text2);

	}

}
