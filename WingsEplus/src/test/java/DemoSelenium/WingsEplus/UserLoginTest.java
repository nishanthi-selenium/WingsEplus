package DemoSelenium.WingsEplus;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import FactoryDesignPattern.DriverManager;
import FactoryDesignPattern.DriverManagerFactory;
import Pageobject.HomePage;
import Pageobject.LoginPage;
import Pageobject.LoginWelcomePage;
import Resources.Base;


public class UserLoginTest extends Base {

	public WebDriver driver;
	DriverManager driverManager;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) {
		// one is inheritance
		System.out.println("basePageNavigation");
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		HomePage hp = new HomePage(driver);
		hp.getNavLogin().click();

		LoginPage lp = new LoginPage(driver); // driver.findElement(By.css()
		lp.getLogin().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);

		lp.getLoginBtn().click();
		// ForgotPassword fp= lp.forgotPassword();
		// fp.getEmail().sendKeys("xxx");
		// fp.sendMeInstructions().click();
		LoginWelcomePage lwp = new LoginWelcomePage(driver);
		System.out.println("login click");
	
		if (driver.getCurrentUrl().equals("https://wingseplus.com/login/"))
		{
	
			System.out.println("valid username and password");
			lwp.validateWelcomeText();    
			System.out.println("validateWelcomeText");
	        Actions builder = new Actions(driver);
	        builder.moveToElement(lwp.getUserPath()).build().perform();        
	       // builder.moveToElement(lwp.getLogoutPath()).build().perform();
	        lwp.getLogoutPath().click();
		}else
		{
			log.info("invalid username and password");
			System.out.println("invalid username and password");
		}
		
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// coloumn stands for how many values per each test

		// Array size is 2
		// 0,1
		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "teststudent1";
		data[0][1] = "teststudent1";
		data[0][2] = "Student 1 info";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Student 2 info";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();

	}
}
