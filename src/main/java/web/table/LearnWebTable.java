package web.table;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Find the header and print the texts
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='customers']//th"));
		int headerSize = header.size();
		System.out.println("The header size is :" + headerSize);

		List<String> listOfHeaders = new ArrayList<String>();
		// for each loop
		for (WebElement each : header) {
			String headerText = each.getText();
			// System.out.println("The header of texts is :" + headerText);
			listOfHeaders.add(headerText);
		}
		System.out.println("The header of texts is :" + listOfHeaders);

		// for loop
//		for (int i = 0; i < header.size(); i++) {
//			WebElement headerText = header.get(i);
//			String Text = headerText.getText();
//			listOfHeaders.add(Text);
//		}
//		System.out.println("The header of texts is :" + listOfHeaders);

		// Table Row
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowSize = row.size();
		System.out.println("The size of the row is :" + rowSize);

		// print the row data
		List<String> rowData = new ArrayList<String>();

		for (WebElement eachData : row) {
			String rowDataText = eachData.getText();
			rowData.add(rowDataText);
		}
		System.out.println("The row of texts is:" + rowData);

		// first row first data
		WebElement rowFirstData = driver.findElement(By.xpath("//table[@id='customers']//tr[1]/th[1]"));
		String data = rowFirstData.getText();

		System.out.println("The First row first data is :" + data);

		// 2nd row 3rd data
		WebElement secondRowData = driver.findElement(By.xpath("//table[@id='customers']//tr[2]/td[3]"));
		String data1 = secondRowData.getText();
		System.out.println("The second row third data is :" + data1);

		// Table column
		List<WebElement> coulmnData = driver.findElements(By.xpath("//table[@id='customers']//tr/td"));
		int columnSize = coulmnData.size();
		System.out.println("The colum size is:" + columnSize);

		List<String> datacoulmn = new ArrayList<String>();

		// for each
		for (WebElement eachColumn : coulmnData) {
			String columnDataText = eachColumn.getText();
			datacoulmn.add(columnDataText);
		}
		System.out.println("The colum data:" + datacoulmn);

		List<String> fullData = new ArrayList<String>();

		// Print all the row and column data
		for (int i = 1; i <= row.size(); i++) {
			List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']//tr[" + i + "]//td"));
			for (int j = 1; j <= cols.size(); j++) {
				String colsData = driver.findElement(By.xpath("//table[@id='customers']//tr[" + i + "]//td[" + j + "]"))
						.getText();
				System.out.println(colsData);
				fullData.add(colsData);
			}

		}
		System.out.println("The full data of rows and columns is :" + fullData);
	}

}
