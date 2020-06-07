package FactoryDesignPattern;

public class DriverManagerFactory {

	public static DriverManager getDriverManager(String browserName) {

		DriverManager driverManager = null;
		if (browserName.equals("CHROME")) {

			driverManager = new ChromeDriverManager();

		}else{
			// need to implement for IE
		}

		return driverManager;

	}

}
