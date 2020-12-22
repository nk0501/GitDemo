package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	By email = By.id("user_email");
	
	public WebElement getmail()
	{
		return driver.findElement(email);
	}
	
	By Password= By.id("user_password");
	
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	
	By login = By.cssSelector("[value='Log In']");
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}	
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotPassword).click();
	 return new ForgotPassword(driver);
	}
	
	

}
