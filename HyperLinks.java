package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/pages/Link.html");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// go to home page
		driver.findElement(By.xpath("//a[@link='blue']")).click();
		//verify the home page
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("TestLeaf - Selenium Playground"))
			System.out.println(("Verfied the home page"));
		else
			System.out.println("not in home page");
		driver.findElement(By.linkText("HyperLink")).click();
		//Find where am supposed to go without clicking me?

		String attribute =driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(attribute);
		//Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title1=driver.getTitle();
		if(title1.equals("404 Not Found"))
			System.out.println("The page is broken");
		else
			System.out.println("The page is not broken");

		//Go to Home Page (Interact with same link name)
		driver.navigate().back();
        Thread.sleep(5000);
		String home1=driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href");
		String home2=driver.findElement(By.xpath("//a[text()='Go to Home Page']")).getAttribute("href");
		if (home1.equals(home2))
				System.out.println("Both links are same");
		else
			System.out.println("Not same link");
		//How many links are available in this page?
		List<WebElement> findelements =  driver.findElements(By.tagName("a"));

		int size = findelements.size();
        System.out.println("Links: "+ size);






	}

}
