package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import FactoryDesignPattern.DriverManager;
import FactoryDesignPattern.DriverManagerFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	private WebDriver driver;
	public Properties prop;
	public DriverManager driverManager;

	public WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		// System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")
						+ "//src//main//java//resources//data.properties");

		prop.load(fis);

		// String browserName=System.getProperty("browser"); // Parameter from
		// Maven
		String browserName = prop.getProperty("browser");
		driverManager = DriverManagerFactory.getDriverManager(browserName);
		driver = driverManager.getWebDriver();

		// hard coded
		// driverManager =
		// DriverManagerFactory.getDriverManager(DriverType.CHROME);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	// Click Method
	public void click(By elementLocation) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).click();
	}

	// Write Text
	public void writeText(By elementLocation, String text) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).sendKeys(text);
	}

	// Read Text
	public String readText(By elementLocation) {
		waitVisibility(elementLocation);
		return driver.findElement(elementLocation).getText();
	}

	// Wait
	public void waitVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
