package extentReportPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentReportclass {
	ChromeDriver driver;
	// making a variable with the extentreports class
	ExtentReports extent;
	// making a variable with the extenttest class
	ExtentTest logger;
	@BeforeTest
	public void BT()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32_101\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		//this will append the logger file and store in the  folder called Test_Output
		extent = new ExtentReports(System.getProperty("user.dir") + "//Test Output//Liesl.html");
		
		// we give it the path so that it will load the configuraton
		extent.loadConfig(new File(System.getProperty("user.dir") + "//src//extent-config.xml"));
	}
	
	@Test
	public void test() throws InterruptedException
	{
		// we start the test
		logger = extent.startTest("OrangeHRM");
		
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		
		// we run logs to see how the test comes out
		logger.log(LogStatus.PASS, "WebPage Opened");
		String Title = driver.getTitle();
		logger.log(LogStatus.PASS, Title);
		
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");  //gives the username
		logger.log(LogStatus.PASS, "USername enetred");
		
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("admin123"); //gives the password
		
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click(); //clicks on the login button
		logger.log(LogStatus.PASS, "Logged In Succesfully");
		Thread.sleep(3000); //sleep time duration
		
		//we end the test
		extent.endTest(logger);
		// we flush the test into html
		extent.flush();
		// we finally close it
		extent.close();
		
	}
}
