package handle_WebElement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class SelectTag_Dropdown_multiselect extends DriverSetup {
	
	public static String baseUrl = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe";
	
	@Test
			
	public void SelectMultiSelect() throws InterruptedException {
		
		driver.get(baseUrl);
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//iframe[@title='W3Schools Free Online Web Tutorials']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
				
	}
	
	

}
