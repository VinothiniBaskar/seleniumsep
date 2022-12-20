package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://letcode.in");
		driver.manage().window().maximize();
		//ImplicitWait  is selenium wait
		//Implicit wait is used for all the elements
		//Set the time for the implicit wait -->Standard time is 30s
		//If it finds an element at 3s or 4s or 5s it will contiue to the rest of the elements
		//If it couldn't find an element until wait for 30s and it will throw the exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Without using implicit wait exception will be thrown immediately
		//With using implicit wait it will wait untill the given time and it will throw the exception
		WebElement login = driver.findElement(By.linkText("Log in"));
		Actions builder=new Actions(driver);
		builder.moveToElement(login).click().perform();
		
		driver.findElement(By.name("email")).sendKeys("koushik350@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass123$");
		driver.findElement(By.xpath("//button[contains(@class,'button is-primary')]")).click();
		String actualTitle="LetCode with Koushik";
		String title = driver.getTitle();
		System.out.println("The of the page is :"+title);
		
		Assert.assertEquals(actualTitle, title);
		
		
	}

}
