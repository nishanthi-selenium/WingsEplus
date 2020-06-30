package Pageobject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Resources.Base;



public class LoginWelcomePage {
	public static Logger log =LogManager.getLogger(Base.class.getName());
	public LoginWelcomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}
	public WebDriver driver;

	private By welcomeTextPath = By.xpath("//span[@class='wlsm-font-bold']");
	private By userPath = By.xpath("//div[contains(text(),'Howdy,')]");
	private By userMenuPath = By.xpath("li[@id='wp-admin-bar-my-account']//div[@class='ab-sub-wrapper']");
	
	private By logoutPath  = By.xpath("html[1]/body[1]/div[1]/div[1]/ul[2]/li[2]/div[2]/ul[1]/li[2]/a[1]");

	// methods public
	public WebElement getWelcomeTextElement() {
		return driver.findElement(welcomeTextPath);
	}
	public WebElement getUserPath() {
		return driver.findElement(userPath);
	}
	public WebElement getUserMenuPath() {
		return driver.findElement(userMenuPath);
	}
	public WebElement getLogoutPath() {
//		WebElement industries = 
//				driver.findElement(By.cssSelector("div.columns.three.alpha > ul"));
//				List<WebElement> links = getUserMenuPath().findElements(By.tagName("li"));
//				System.out.println(links);
//				for (int i = 0; i < links.size(); i++)
//				{
//				    System.out.println(links.get(i).getText());
//				    if(links.get(i).getText().equalsIgnoreCase("Log Out"))
//				    {
//				    logoutPath = By.linkText("Log Out");
//				    }
//				}
				return driver.findElement(logoutPath);
	}
	
	
	public void validateWelcomeText() {
		Assert.assertEquals( getWelcomeTextElement().getText() , "teststudent1");
		log.info("Successfully validated Text message");
		System.out.println("Successfully validated Text message");
	}
	
	
}
