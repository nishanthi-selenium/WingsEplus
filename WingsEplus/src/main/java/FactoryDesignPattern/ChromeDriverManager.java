package FactoryDesignPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createWebDriver() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		// ChromeOptions options =new ChromeOptions();
		// if(browserName.contains("headless"))
		// {
		// options.addArguments("headless");
		// }
		this.driver = new ChromeDriver(options);

	}

}
