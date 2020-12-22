package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver; 
	// you just created a dummy driver . You have to provide it selenium life otherwise, it will throw NullpointerException.
	
	By signin=By.cssSelector("a[href*='sign_in']"); // Best practice to define page objects = Define Objects first , then concentrate on methods.
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver; 
		// life is assigned to driver object created in Landing page . "this. driver" refers to variable which is created inside the class . 
		
	}
	
	public LoginPage getLogin()
	{
		//return driver.findElement(signin); 
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	By title = By.xpath("//div[@class='text-center']");
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	By navbar = By.cssSelector("a[href*='sign_up']");
	public WebElement getnavbar()
	{
		return driver.findElement(navbar);
	}
	
	
	

}
