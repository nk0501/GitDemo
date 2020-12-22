package Academy_3006;
import org.apache.logging.log4j.LogManager;
import resources.Base;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateNavBar extends Base{
	public WebDriver driver; // to run test one at a time, we need to define a local driver .
	private static Logger Log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void validateNavBar() throws IOException 
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	   // driver.get("http://qaclickacademy.com");
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		Log.info("NavBar checking done successfully ");
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	

}
