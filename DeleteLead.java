package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		//	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//Click on Phone
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		//Enter phone number

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("89");

		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		//Capture lead ID of First Resulting lead
		String LeadID =driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(LeadID);
		//Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//Click Delete
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID);
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String t1=driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		Thread.sleep(5000);
		System.out.println(t1);
		if(t1.contains("No records to display"))
		{
			System.out.println("Text is correctly showed");
		}else
			System.out.println("text is wrong");
		//Close the browser (Do not log out)
		driver.close();
	}

}
