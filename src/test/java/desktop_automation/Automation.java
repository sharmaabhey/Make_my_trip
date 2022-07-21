package desktop_automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class Automation {
	
	
	//WebDriver driver;
	public static WindowsDriver driver= null;
	//WiniumDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	
	public void launch_application() throws Exception    {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("testing", "C:\\Windows\\System32\\calc.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("devicename1", "WindowsPC");
		
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		DesktopOptions option = new DesktopOptions();
//		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
//		
//		
//		 driver= new WiniumDriver(new URL("http://localhost:9999"), option);
//		 Thread.sleep(2000);
		
		
		
		
		
	}

	
	
	@Test
	
	public void adding_values() throws Exception   {
		Thread.sleep(5000);
		driver.findElement(By.id("num1Button")).click();
		driver.findElement(By.id("plusButton")).click();
		driver.findElement(By.id("num8Button")).click();
		driver.findElement(By.id("equalButton")).click();
		String str = driver.findElement(By.id("CalculatorResults")).getAttribute("name");
		System.out.println(str);
		
	}
	
	
	
	
//	@AfterMethod
//	
//	
//	public void close_app() {
//		driver.quit();
//		
//	}

}
