package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//select training program by index
		WebElement dropdwn=driver.findElement(By.id("dropdown1"));
		Select select =new Select(dropdwn);
		select.selectByIndex(1);
		//select training program by text
		WebElement dropdwn1=driver.findElement(By.name("dropdown2"));
		Select select1=new Select(dropdwn1);
		select1.selectByVisibleText("Selenium");
		//select training program by value
		WebElement dropdwn2=driver.findElement(By.id("dropdown3"));
		Select select2=new Select(dropdwn2);
		select2.selectByValue("1");
		
		//Get the number of dropdown options
		WebElement dropdwn3 = driver.findElement(By.className("dropdown"));
		Select select3 = new Select(dropdwn3);
		List <WebElement> options = select3.getOptions();
		System.out.println("No of options in the dropdown: " + options.size());
		//Select options by using sendkeys
		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Loadrunner");
		}

}
