package smoketest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import library.Utility;

public class VerifyTitle {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void verifyapptitle() {
		

System.setProperty("webdriver.chrome.driver","c:\\Test\\chromedriver.exe");
	report=new ExtentReports("C:\\Users\\Vivek Chennupati\\Desktop\\priya_Downloads\\JAR FILES\\Extent_Report_version2_JAR\\Reports_version2\\advancereportversion2.html");
	
	logger=report.startTest("Verifyblogtitle");
	
	logger.log(LogStatus.INFO,"Browse up and running");
	 driver=new ChromeDriver();
	 
	driver.manage().window().maximize();
	
	
	driver.get("http://automationpractice.com/index.php");
	logger.log(LogStatus.INFO,"Application is up and running");
	
	
	String title=driver.getTitle();
	logger.log(LogStatus.INFO, "titlecaptured");
	
	
	Assert.assertTrue(title.contains("store"));
	logger.log(LogStatus.PASS,"title is verfied");
	
	
	}

	
	
	@AfterMethod
	public void teardown(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshot_path=Utility.capturescreenshot(driver ,result.getName());
			String image=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL,"Title Verifiction",image);
			
		}
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Users\\Vivek Chennupati\\Desktop\\priya_Downloads\\JAR FILES\\Extent_Report_version2_JAR\\Reports_version2\\advancereportversion2.html");
	}
}
