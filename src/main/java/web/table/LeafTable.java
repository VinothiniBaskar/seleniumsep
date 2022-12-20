package web.table;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/table.xhtml;jsessionid=node0czoiyda56jju1ac3yed920yd2432757.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// find the header size and data
		List<WebElement> headers = driver.findElements(By.xpath("//table[@role='grid']//tr[1]//th"));
		int headerSize = headers.size();
		System.out.println("The header size is :" + headerSize);

		// print the header data
		List<String> data = new ArrayList<String>();
		for (WebElement eachHeader : headers) {
			String text = eachHeader.getText();
			data.add(text);
		}

		System.out.println("The header data is :" + data);

		// Find row size and print 2nd row with data

		List<WebElement> row = driver.findElements(By.xpath("//table[@role='grid']//tr//td"));
		int rowSize = row.size();
		System.out.println("The row size is :" + rowSize);

		List<String> data1 = new ArrayList<String>();
		// print the row data
		for (WebElement eachRowData : row) {
			String text1 = eachRowData.getText();
			data1.add(text1);

		}
		System.out.println("The  data is :" + data1);

		// print all row and column
		List<String> fullData = new ArrayList<String>();

		for (int i = 1; i <= row.size(); i++) {
			List<WebElement> colData = driver.findElements(By.xpath("//table[@role='grid']//tr[" + i + "]//td"));
			for (int j = 1; j <= colData.size(); j++) {
				String col =driver.findElement(By.xpath("//table[@role='grid']//tr[" + i + "]//td["+j+"]")).getText();
				fullData.add(col);
			}
		}
		System.out.println("The full   data is :" +fullData);
	}
}
