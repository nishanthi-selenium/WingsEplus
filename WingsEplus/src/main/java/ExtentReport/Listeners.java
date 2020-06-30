/**
 * @author nishanthi
 *
 */
package ExtentReport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Resources.Base;

public class Listeners extends Base implements ITestListener {

	
	private static String fileSeperator = System.getProperty("file.separator");

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method "
				+ getTestMethodName(iTestResult) + " start");
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName());
		ExtentTestManager
				.getTest()
				.log(Status.INFO,
						("I am in onTestStart method " + getTestMethodName(iTestResult)));

	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method "
				+ getTestMethodName(iTestResult) + " succeed");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		ExtentTestManager
				.getTest()
				.log(Status.INFO,
						("I am in onTestSuccess method " + getTestMethodName(iTestResult)));
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method "
				+ getTestMethodName(iTestResult) + " failed");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		ExtentTestManager
				.getTest()
				.log(Status.INFO,
						("I am in onTestFailure method  " + getTestMethodName(iTestResult)));

		// Screen sheet

		System.out.println("***** Error " + iTestResult.getName()
				+ " test has failed *****");

		ITestContext context = iTestResult.getTestContext();
		System.out.println("***** context " + context);
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		System.out.println("***** driver " +driver);
		String testClassName = getTestClassName(iTestResult.getInstanceName())
				.trim();

		String testMethodName = iTestResult.getName().toString().trim();
		String screenShotName = testMethodName + ".png";

		if (driver != null) {
			String imagePath = ".." + fileSeperator + "Screenshots"
					+ fileSeperator + "Results" + fileSeperator + testClassName
					+ fileSeperator
					+ takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
		}

	}

	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method "
				+ getTestMethodName(iTestResult) + " skipped");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		ExtentTestManager
				.getTest()
				.log(Status.INFO,
						("I am in onTestSkipped method" + getTestMethodName(iTestResult)));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio "
				+ getTestMethodName(iTestResult));
		ExtentTestManager
				.getTest()
				.log(Status.INFO,
						("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult)));
	}

	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());

	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public static String takeScreenShot(WebDriver driver,
			String screenShotName, String testName) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("Screenshots" + fileSeperator
					+ "Results" + fileSeperator + testName, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot "
					+ e.getCause());
			return null;
		}
	}

	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}

}
