package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundButton {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/pages/Button.html");
		// Maximise the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click button to travel home page
		driver.findElement(By.xpath("//button[@id='home']")).click();
		//verify the home page
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("TestLeaf - Selenium Playground"))
			System.out.println(("Verfied the home page"));
		else
			System.out.println("not in home page");

		driver.findElement(By.xpath("//h5[text()='Button']")).click();
		//Find position of button (x,y)
		Point location= driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		int x= location.getX();
		System.out.println("X:"+ x);
		int y=location.getY();
		System.out.println("Y:"+ y);

		//Find button color
		String Cssvalue= driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println(Cssvalue);
		//Find the height and width
		Dimension size=driver.findElement(By.id("size")).getSize();
		int height=size.height;
		System.out.println("Height is :"+height);
		int width=size.width;
		System.out.println("Width is  :"+width);




















	}

}
