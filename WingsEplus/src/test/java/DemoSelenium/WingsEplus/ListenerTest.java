package DemoSelenium.WingsEplus;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Resources.Base;

public class ListenerTest extends Base{
	
	public WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		System.out
				.println(" Before Method will execute before every test method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out
				.println("After Method will execute after every test method ");
	}

	@BeforeClass
	public void beforeClass(ITestContext context) throws IOException {
		driver = initializeDriver();
		System.out
				.println("Before Class will always execute prior to Before Method and Test Method ");
		context.setAttribute("driver", driver);
	
	}

	@AfterClass
	public void afterClass() {
		System.out
				.println("After Class will always execute later to After Method and Test method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out
				.println("Before Test will always execute prior to Before Class, ,Before Method and Test Method ");
	}

	@AfterTest
	public void afterTest() {
		System.out
				.println("After Test will always execute later to After Method, After Class ");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out
				.println("Before Suite will always execute prior to all annotations or tests in the suite.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out
				.println("After suite will always execute at last when all the annotations or test in the suite have run.");
	}

	@Test
	public void test1() {
		System.out.println("I am in test1 test method and it will pass.");
	}

	@Test(expectedExceptions = RuntimeException.class)
	public void test2() {
		System.out.println("I am in test2 test method and it will fail.");
	}

	@Test
	public void test3() {
		throw new SkipException("Skipping the test3 test method!");
	}

	private int i = 0;

	@Test(successPercentage = 60, invocationCount = 5)
	public void test4() {
		i++;
		System.out.println("test4 test method, invocation count: " + i);
		if (i == 1 || i == 2) {
			System.out.println("test4 failed!");
			Assert.assertEquals(i, 8);
		}
	}

}
