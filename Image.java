package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on this image to go home page
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		String title= driver.getTitle();
		if(title.equals("TestLeaf - Selenium Playground"))
		{
			System.out.println("Clicking on image is landing in homepage");
		}else
		{
			System.out.println("Not in home page");
		}
		
		driver.navigate().back();
		//verify i am broken
		String Broken=driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).getAttribute("naturalHeight");
		if (Broken.equals("0")) {
			System.out.println("The given image is broken");
		}
		else{
			System.out.println("The given image is not broken");
		}

		//Click by using Keyboard or Mouse
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
	    String title2=driver.getTitle();
	    if(title2.equals("TestLeaf - Selenium Playground"))
	    {
	    System.out.println("The image is clicked");
	    }else
	    	System.out.println("The image is not clicked");


	}

}
