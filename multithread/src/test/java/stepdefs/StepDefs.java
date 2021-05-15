package stepdefs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import commonFuntions.GlobalConfigurations;
import commonFuntions.configurations;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
public class StepDefs {
	
Scenario scenario;
public static ExtentTest test;
	@Before
	public void SetUp(Scenario s) {
		scenario = s;
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
		
		configurations configuration=new configurations();
		configuration.setDriver(wd);
		
		System.out.println(s.getName());
		Thread.currentThread().setName(s.getName());
		
		GlobalConfigurations.configMap.put(Thread.currentThread().getName(),configuration);
	}
	
	@AfterStep
	public void attach_screenshot() throws Throwable {
		//Thread.sleep(2000);
		configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		  
		  WebDriver driver=config.getDriver();
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(takeScreenShot(driver)); //for html
		//scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png"); //for spark
	}
	
	
	@Given("I open the Browser and Navigate to the URL {string}")
	public void i_open_the_Browser_and_Navigate_to_the_URL(String string) {
		
		 configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		  
		  WebDriver driver=config.getDriver();
		
		driver.get(string);
		scenario.write("Opened the Browser with URL: " + string);
	}
	
	
	@Then("User enters the text in search field")
	public void user_enters_the_text_in_search_field() {
		 configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		  
		  WebDriver driver=config.getDriver();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello");
		scenario.write("Entered text Hello");
	}
	
	@Then("User clicks on the link")
	public void user_clicks_on_the_link() {
		configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		  
		  WebDriver driver=config.getDriver();
		
		driver.findElement(By.xpath("//a[@id='nav-orders']")).click();
		scenario.write("User clicks on Orders link");
	}
	public static String takeScreenShot(WebDriver driver) throws IOException
	{
		String screenshot="";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		
		String destPath=System.getProperty("user.dir")+"//test-output//screenshots//"+System.currentTimeMillis()+".png";
		File DestFile=new File(destPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		byte[] fileContent=FileUtils.readFileToByteArray(SrcFile);
		
		screenshot="data:image/png;base64,"+ Base64.getEncoder().encodeToString(fileContent);
		
		return screenshot;
	}
	
	
	
}
