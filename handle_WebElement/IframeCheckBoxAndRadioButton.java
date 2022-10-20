package handle_WebElement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class IframeCheckBoxAndRadioButton extends DriverSetup {
	
	public static String baseUrl = "https://jqueryui.com/checkboxradio/";
	
	@Test
	
	public void CheckIframe() throws InterruptedException{
		
		driver.get(baseUrl);
				
		By iframelocateBy = By.className("demo-frame");
			
		driver.switchTo().frame(0);	
		
		driver.findElement(By.cssSelector("label[for='radio-1']")).click();	
		
		driver.switchTo().defaultContent();	
		
		//driver.findElement(By.xpath("//a[normalize-space()='Draggable']")).click();
		
		Thread.sleep(10000);
		
		driver.switchTo().frame(driver.findElement(iframelocateBy));
		driver.findElement(By.cssSelector("label[for='radio-2']")).click();	
		
		//checkbox
		
		driver.findElement(By.cssSelector("label[for='checkbox-1']")).click();
		
		driver.findElement(By.cssSelector("label[for='checkbox-3']")).click();
		
		driver.findElement(By.cssSelector("label[for='checkbox-4']")).click();
			
		Thread.sleep(10000);
		driver.switchTo().defaultContent();			
		
	}	

}
