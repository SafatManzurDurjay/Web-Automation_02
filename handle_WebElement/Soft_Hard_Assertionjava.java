package handle_WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import utilities.DriverSetup;

@Test

public class Soft_Hard_Assertionjava extends DriverSetup {
	
	public String baseUrl = "http://automationpractice.com/index.php" ;
	
	@Test (priority =1 )

    public void verifyPageTitle() {
	
	driver.get(baseUrl);
	String actualTitle = driver.getTitle();
	
    if(actualTitle.equals("My Store")) {
		
		System.out.println("Pass");
		
	}else {
			System.out.println("Not Pass");
		}
	
	       assertEquals(actualTitle, "My Store");
	       SoftAssert softAssert = new SoftAssert();
	       softAssert.assertEquals(actualTitle, "My Store");
	       System.out.println("Soft Assertion");
	       
	       softAssert.assertAll();   	
				
	}
	
	@Test (priority = 2)
	
	public void verifyPageUrl() {
		
		System.out.println(driver.getCurrentUrl());
		assertNotEquals(driver.getCurrentUrl(), "http://automationpractice.com/index" );;
		
	}
	
	
	
}

