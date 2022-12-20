package selenium.basic;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelenium {
	public static void main(String[] args) {
		//set the path using wdm
		WebDriverManager.chromedriver().setup();
		//Get the path in console using getProperty method
		//System.out.println(System.getProperty("webdriver.chrome.driver"));
		//Launch the browser
//		WebDriver driver=new ChromeDriver();
		//or
		ChromeDriver driver=new ChromeDriver();
		//open the url and load
		driver.get("http://leaftaps.com/opentaps/");
		//Maximize the window
		driver.manage().window().maximize();

	}

}
