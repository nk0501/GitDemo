package Academy_3006;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver; // to run test one at a time, we need to define a local driver .
	private static Logger log = LogManager.getLogger(Base.class.getName());

@Test(dataProvider="getData")
 
 public void basePageNavigation(String Uname,String Pword,String Text) throws IOException
 {
	 driver= initializeDriver();
	 driver.get(prop.getProperty("url"));
	 //driver.get("http://qaclickacademy.com");
	 LandingPage lp=new LandingPage(driver); // If you want to send anything with arguments, you need to come up with constructor.
	 LoginPage lp2 = lp.getLogin();
	 //LoginPage lp2 = new LoginPage(driver);
	 lp2.getmail().sendKeys(Uname);
	 lp2.getPassword().sendKeys(Pword);
	 log.info(Text);
	 lp2.getLogin().click();  
	 ForgotPassword fp = lp2.forgotPassword();
	fp.getSignin().sendKeys("nayan.kumar@morrisonsplc.co.uk");
	fp.sendmeinstructions();
	 
	 driver.close(); // If AfterTest is not working, you can close the browser like this also.
 }
 
 
 // row-      how many different sets of data you want to provide .Array size taken.
 // column -  how many values which you want to provide . Array size is taken here also.
 @DataProvider
 public Object[][] getData()
 {
	 Object[][] data = new Object[2][3];
	 
	 data[0][0] = "nayan.kumar@morrisonsplc.co.uk";
	 data[0][1] = "123456";
	 data[0][2] = "Restricted User";
	 
	 
	 data[1][0] = "ronith.gund@morrisonsplc.co.uk";
	 data[1][1] = "1234567";
	 data[1][2] = "Non Restricted User";
	
	 return data;
 } 
 /*@AfterTest
 public void tearDown()
 {
	 driver.quit();
 }*/
 
}
 
