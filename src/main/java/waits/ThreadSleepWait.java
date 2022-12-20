package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreadSleepWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://letcode.in");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.linkText("Log in"));
		Actions builder=new Actions(driver);
		builder.moveToElement(login).click().perform();
		//Thread.sleep is a java wait
		//It is applicable for the particular element on the web page
		//Every time we have to give for the each element
		//If it finds an element at 1s or 2s ,even it finds the elemet it is blindly wait for given time
		//If it couldn't find an element it will wait until 3s and it will throw the Exception
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("koushik350@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass123$");
		driver.findElement(By.xpath("//button[contains(@class,'button is-primary')]")).click();
		String actualTitle="LetCode with Koushik";
		String title = driver.getTitle();
		System.out.println("The of the page is :"+title);
		
		Assert.assertEquals(actualTitle, title);
	}

}
