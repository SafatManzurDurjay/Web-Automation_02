package handle_WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.internal.invokers.Arguments;
import org.testng.internal.invokers.TestMethodArguments;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import net.bytebuddy.asm.Advice.Argument;
import utilities.DriverSetup;

public class Alerts_window_Js_Scroll_waits extends DriverSetup {
	
	
	public String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";
	
	@Test
	public void handleAlert() throws InterruptedException {
		
		driver.get(baseUrl);
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		Thread.sleep(3000);
	
		String resultString = driver.findElement(By.id("result")).getText();
		assertEquals(resultString, "You successfully clicked an alert");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(3000);
		resultString = driver.findElement(By.id("result")).getText();
		
		assertEquals(resultString, "You clicked: Ok");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(3000);
		
		resultString = driver.findElement(By.id("result")).getText();
		assertEquals(resultString, "You clicked: Cancel");
	
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		System.out.println(alert.getText());	
		alert.sendKeys("Hello");
		alert.accept();
		Thread.sleep(3000);
		
		resultString = driver.findElement(By.id("result")).getText();
		assertTrue(resultString.contains("Hello"));
		
		Thread.sleep(3000);
			
	}
	
	@Test
	public void handleBrowserWindow() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Thread.sleep(3000);
		
		driver.close();
		
		//driver.quit();
		
		Thread.sleep(3000);
		
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
	
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://google.com");
		Thread.sleep(3000);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
		driver.findElement(By.id("openwindow")).click();
		//Thread.sleep(3000);
		
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		List<String> handleslist = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(handleslist.size());
		
		driver.switchTo().window(handleslist.get(1));
		System.out.println(driver.getTitle());
	    System.out.println(driver.getWindowHandle());
		
		Thread.sleep(3000);
				
			
	}
	
	@Test
	public void useJSInAutomation() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);
		
	    JavascriptExecutor js =  (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    Thread.sleep(3000);
	    
	    js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	    Thread.sleep(3000);
	    
	    WebElement element = driver.findElement(By.id("mousehover"));
	    Thread.sleep(3000);
	    
	    js.executeScript("arguments[0].scrollIntoView();", element);
	    Thread.sleep(3000);    
		
	}
	
	@Test
	
	public void useCommonMethod() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://qavbox.github.io/demo/delay/");
			
		clickOnElement(By.id("loaderStart"));
		
		assertTrue(getElementText(By.id("loaderdelay")).contains("I appeared after 5 sec loading"));
		
	}	
	
	public WebElement getElement(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	public void clickOnElement(By locator) {
		
		getElement(locator).click();
		
	}
	
	public String getElementText(By locator) {
		
		return getElement(locator).getText();
		
	}
	
	
	
}
