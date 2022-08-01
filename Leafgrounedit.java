package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgrounedit {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		// Maximise the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter Email Address
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kavithailayaraja92@gmail.com");
		//Append a text and press keyboard tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(" Kavitha",Keys.TAB);
		//get a default text
       String text= driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
       System.out.println(text);
       //clear the text
       driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
       //confirm edit field is disabled
      boolean enable= driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
      if(enable==false)
      {
    	  System.out.println("The edit field is disabled");
      }else
    	  System.out.println("The edit field is  enabled");
	}

}
