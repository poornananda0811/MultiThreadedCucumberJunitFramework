package commonFuntions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.google.common.io.Files;


public class commonmethods  {

	WebDriver driver;
	WebElement element;
	ExtentTest test1;
	ExtentLink link;
	
	
	public String takeScreenShot(WebDriver driver) throws IOException
	{
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		String destPath=System.getProperty("user.dir")+"//screenshots//"+System.currentTimeMillis()+".png";
		File DestFile=new File(destPath);
		//Copy file at destination
		Files.copy(SrcFile, DestFile);
		
		
		
		return destPath;
	}
	
}
