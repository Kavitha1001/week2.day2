package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		// Maximize the window
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Select the languages that you know?
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']//following::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']//following::input[@type='checkbox'][3]")).click();
		//Confirm Selenium is checked
		boolean select =driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following::input")).isSelected();
		if(select)
		{
			System.out.println("The Checkbox is selected");
		}else
			System.out.println("Checkbox is not selected");

		//DeSelect only checked
		List<WebElement> findelement=driver.findElements(By.xpath("//label[text()='DeSelect only checked']//following::input"));
		for (int i = 0; i < findelement.size(); i++) {
			if(findelement.get(i).isSelected())
			{
				findelement.get(i).click();
			}

		}
		System.out.println("Deselected the Selected checkbox");
		//Select all below checkboxes
		List<WebElement> findelement1=driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']//following::input"));

		for (int j = 0; j < findelement1.size(); j++) {
			findelement1.get(j).click();

		}
		System.out.println("All checkbox are selected");
	}

}

