package handle_WebElement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilities.DriverSetup;

public class Action_Hover_MoveToElement_DoubleClick_RightClick extends DriverSetup {
	
	public String baseUrl = "https://demoqa.com/menu";
	
	@Test
	
	public void checkAction() throws InterruptedException {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement mainMenuElement = driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
		action.clickAndHold(mainMenuElement).build().perform();
		
		Thread.sleep(3000);
		
		WebElement submenuElement = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[@class='nav-menu-container']/ul[@id='nav']/li/ul/li[2]/a[1]"));
		System.out.println(submenuElement.getText());
		submenuElement.click();
		
		Thread.sleep(3000);
		
		WebElement subMenuElement3 = driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));	
		System.out.println(subMenuElement3.getText());
		subMenuElement3.click();
		
		
		action.clickAndHold(subMenuElement3).build().perform();
		Thread.sleep(3000);
		
		WebElement subsubmenuElement = driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));
		System.out.println(subsubmenuElement.getText());
		subsubmenuElement.click();
		
		Thread.sleep(3000);
		
		/*driver.get("https://www.daraz.com.bd/");
		Thread.sleep(3000);
		WebElement catElement = driver.findElement(By.xpath("//a[normalize-space()='About Daraz']"));
		action.moveToElement(catElement).build().perform();
		
	    */Thread.sleep(3000);
		
		
	}
		
}
