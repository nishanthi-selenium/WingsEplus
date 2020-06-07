package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}
	
	private By navLogin = By.xpath("//a[contains(text(),'Login')]");
	//methods public
	public WebElement getNavLogin()
	{
		return driver.findElement(navLogin);
	}
	
}
