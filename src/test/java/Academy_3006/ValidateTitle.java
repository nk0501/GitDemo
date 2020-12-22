package Academy_3006;
import java.io.IOException;
import resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

public class ValidateTitle extends Base  {
	public WebDriver driver; // to run test one at a time, we need to define a local driver .
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void validatetitlenavigation() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver Initialized successfully");		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage ");		
		
	    //driver.get("http://qaclickacademy.com");
	    LandingPage lp=new LandingPage(driver);
	    Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
	    log.info("Checking done unsuccessfully ");	
	    
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
