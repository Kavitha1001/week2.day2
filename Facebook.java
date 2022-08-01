package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();	
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Kavitha");
		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("Sankarasubbu");
		// Step 9: Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("8903103764");
		// Step 10: Enter the password
		driver.findElement(By.name("reg_passwd__")).sendKeys("July@2022");
		// Step 11: Handle all the three drop downs
		WebElement date=driver.findElement(By.name("birthday_day"));
		Select select =new Select(date);
		select.selectByValue("10");
		WebElement month=driver.findElement(By.name("birthday_month"));
		Select mon=new Select(month);
		mon.selectByValue("1");
		WebElement year=driver.findElement(By.name("birthday_year"));
		Select yr=new Select(year);
		yr.selectByValue("1992");
		// Step 12: Select the radio button "Female" 
		            //( A normal click will do for this step) 
		driver.findElement(By.xpath("//input[@value='1']")).click();

	}

}
