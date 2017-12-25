package Generic;


import java.io.IOException;





import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Base_class {
	
	
	public Process process;
	public AppiumDriver driver;
	
	public void Start_Server() throws IOException, InterruptedException
	{
		//Start server
		
		String Start_server="F:\\App\\Appium\\node.exe F:\\App\\Appium\\node_modules\\appium\\bin\\appium.js";
		 process = Runtime.getRuntime().exec(Start_server);
		
		if(process != null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started the Server");
		}
		
		Thread.sleep(15000);		

		
	}
	
	
	public void LaunchApp() throws InterruptedException, IOException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities().android();
		
		//device details
		capabilities.setCapability("deviceName","Lenovo K50a40");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","6.0");		
		
		//app details
		capabilities.setCapability("appPackage",Utility_class.Reading_properties("Package_name"));
		capabilities.setCapability("appActivity",Utility_class.Reading_properties("Activity_name"));
		
		//Appium Server details
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//wait
		Thread.sleep(5000);	
		
		
		
		
	}
//	public void Capture_screenshot(String TC_ID,String Order_set) throws IOException{
//		
//		Date date=new Date();
//		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd hh=mm-ss");
//		String str=df.format(date)+".png";
//		TakesScreenshot screen=(TakesScreenshot)driver;
//		File screenshotAs = screen.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyDirectory(screenshotAs, new File("‪F:\\screenshot"+TC_ID+"-"+Order_set+"-"+str));
//		
//		
//		
//	}
//	
	public void Explicit_wait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
	}
	
	
	
	
	
	
	
	
	//Stop server
	public void Stop_Server() throws InterruptedException
	{

		//Stop server
		
		if(process !=null)
		{
			process.destroy();
			Thread.sleep(4000);
			
			System.out.println("Stopped the Appium server");
			
		}
		
		
		
		
	}
	
	}
