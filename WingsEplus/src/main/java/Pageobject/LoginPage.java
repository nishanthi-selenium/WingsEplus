package Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	//Encapsulation example making variable private
	private By login = By.xpath("//input[@id='wlsm-login-username']");
	private By password = By.cssSelector("#wlsm-login-password");
	private By loginBtn = By.cssSelector("#wlsm-login-submit");
	private By forgotPwd = By.xpath("//a[contains(text(),'Lost your password?')]");
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}
	
	//methods public
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
	public WebElement getForgotPwd()
	{
		return driver.findElement(forgotPwd);
	}

}
