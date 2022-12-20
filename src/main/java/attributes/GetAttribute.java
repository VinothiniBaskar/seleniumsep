package attributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttribute {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//i[contains(@class,'pi pi-server')]")).click();
		driver.findElement(By.linkText("Text Box")).click();

		// Get the title of the page
		String title = driver.getTitle();
		System.out.println("The Title of the page is :" + title);

		// Get the value of the textbox using getAttribute
		String attribute = driver.findElement(By.id("j_idt88:name")).getAttribute("placeholder");
		System.out.println("The value of name is :" + attribute);

		driver.findElement(By.id("j_idt88:name")).sendKeys("Vinothini");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("  India");

		// Verify the text box is disabled
		boolean displayed = driver.findElement(By.id("j_idt88:j_idt93")).isDisplayed();
		System.out.println(displayed);
		if (displayed) {
			System.out.println("The Given text box is disabled");
		} else {
			System.out.println("The Given text box is not disabled");

		}

		// Get the value and clear the existing text using clear method
		String attribute2 = driver.findElement(By.xpath("//input[@value='Can you clear me, please?']"))
				.getAttribute("value");
		System.out.println("The Value is :" + attribute2);
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();

		// Get the value
		String attribute3 = driver.findElement(By.xpath("//input[@value='My learning is superb so far.']"))
				.getAttribute("value");
		System.out.println("The Value is :" + attribute3);

		// enter the email id using sendkeys and using Keys.TAB for going to next tab
		driver.findElement(By.xpath("//input[@placeholder='Your email and tab']")).sendKeys("vino@gmail.com", Keys.TAB);
		driver.findElement(By.xpath("//textarea[@placeholder='About yourself']"))
				.sendKeys("I am vino,completed B.Tech IT at the year 2018");

		// Text editor
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("This is a text editor");

		driver.findElement(By.xpath("//div[contains(@class,'col-12 mb-2')]//input[1]")).sendKeys("", Keys.ENTER);
		// Get the text of the webelemet using getText method
		String str = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		// Verify the text
		if (str.contains("Age is mandatory")) {
			System.out.println("I confirm the error message");

		} else {
			System.out.println("error message not found");

		}

		// Get the location of the web element
		WebElement location = driver.findElement(By.xpath("//label[text()='Username']"));
		location.getLocation();
		int x = location.getLocation().getX();
		int y = location.getLocation().getY();
		System.out.println("The location of x and y is :" + x + " " + y + "");

	}

}
