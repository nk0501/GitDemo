package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public ForgotPassword(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebDriver driver;
	By signin=By.id("user_email");
	By sendmeinstructions = By.cssSelector("[name='commit']");
	
	public WebElement getSignin()
	{
		return driver.findElement(signin);
		
	}
	public void sendmeinstructions()
	{
		driver.findElement(sendmeinstructions).click();
	}

}
