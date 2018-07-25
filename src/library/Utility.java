package library;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Utility {
	public static String capturescreenshot(WebDriver driver, String ScreenShotName) throws Exception {
	try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  String dest="C:\\Users\\Vivek Chennupati\\eclipse-workspace\\extentreportversion2\\screensshots\\"+ScreenShotName+".png";
		  File destination=new File(dest);
		 FileUtils.copyFile(source,destination);
		 System.out.println("screen shot captured");
		 return dest;
	} catch (Exception e) {
		
		System.out.println("exception while taking screnshot"+e.getMessage());
		return e.getMessage();
	}
	
	 }
}