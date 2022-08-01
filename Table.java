package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
		
		//Get the count of number of columns
		List <WebElement> column = driver.findElements(By.tagName("th"));
		int count1 = column.size();
		System.out.println("No of columns in the table: "+ count1);
		//Get the count of number of rows
		List <WebElement> row = driver.findElements(By.tagName("tr"));
		int count2 = row.size();
		System.out.println("No of rows in the table: "+ count2);
		//Get the progress value of 'Learn to interact with Elements
		String progress = driver.findElement(By.xpath("//tr[@class='even']")).getText();
		System.out.println("The progress value of Learn to interact with Elements: "+ progress);
		//Check the vital task for the least completed progress
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();

	}

}
