package dropdown.examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicDropdownByUsingSelect {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testleaf.herokuapp.com/pages/Dropdown.html");

		// Select the value by using SelectByIndex
		WebElement data = driver.findElement(By.id("dropdown1"));
		Select value = new Select(data);
		value.selectByIndex(3);

		// Select the value by using SelectByVisbileText
		WebElement data1 = driver.findElement(By.name("dropdown2"));
		Select value1 = new Select(data1);
		value1.selectByVisibleText("Selenium");
		//Verify the selected value in the dropdown
		System.out.println(value1.getFirstSelectedOption().getText());

		// Select the value by using selectByValue
		WebElement data2 = driver.findElement(By.id("dropdown3"));
		Select value2 = new Select(data2);
		value2.selectByValue("3");
		

		// Get the number of items in the dropdown
		WebElement data3 = driver.findElement(By.xpath("//div[@class='example'][4]//select"));
		Select value3 = new Select(data3);
		List<WebElement> listOfOptions = value3.getOptions();
		int number = listOfOptions.size();
		System.out.println("The number of elements is :" + number);

		// select the option by using send keys method -->This is interview question
		WebElement data4 = driver.findElement(By.xpath("//div[@class='example'][5]//select"));
		Select value4 = new Select(data4);
		value4.getOptions();
		data4.sendKeys("Appium");

		// Multiple select
		WebElement data5 = driver.findElement(By.xpath("//div[@class='example'][6]//select"));
		Select value5 = new Select(data5);
		// getOptions method is used to select all the options in the dropdown
		List<WebElement> options = value5.getOptions();
	    

		//select all the options
		for (int i = 1; i < options.size(); i++) {
			options.get(i).click();
			String text = options.get(i).getText();
			System.out.println(text);
			//deselect the item from selected items(it is only for multiple dropdown)
			//value5.deselectByIndex(2);
			//Deselect the items form selected items
			//value5.deselectAll();
			
		}
		
		
		//select 2nd option
		for (int i = 1; i < options.size(); i++) {
			if(i==2)
			options.get(i).click();
			
		}
		
		
		//select 2nd and 3rd option
				for (int i = 1; i < options.size(); i++) {
					if(i==2 && i==3)
					options.get(i).click();
				}

	}

}
