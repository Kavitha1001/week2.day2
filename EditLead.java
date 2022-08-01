package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximise the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	

		//Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// 	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		//	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		//	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		//	Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-element']/following::input[@name='firstName'][3]")).sendKeys("Kavitha");
		//	Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		// Click on first resulting lead
		driver.findElement(By.linkText("Kavitha")).click();
		Thread.sleep(5000);
		// Verify title of the page
		System.out.println("The Title of the page is:"+driver.getTitle());
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("Verfied the title");
		}else
			System.out.println("The title of the page is not View Lead");
		// Click Edit
		driver.findElement(By.linkText("Edit")).click();
		// Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		//click Update
		driver.findElement(By.className("smallSubmit")).click();
		// Confirm the changed name appears
		boolean displayed=driver.findElement(By.id("viewLead_companyName_sp")).isDisplayed();
		System.out.println(displayed);
		//  Close the browser (Do not log out)
		driver.close();

	}

}
