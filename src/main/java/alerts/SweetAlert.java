package alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SweetAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//simple alert
		
		
		
		//Sweet alert -->It has 2 clicks
		//one click-->button
		//2nd click-->alert box-->dismiss or accept--->It is Inspectable
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']//span[2]")).click();
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']//span[2]")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
	}

}
