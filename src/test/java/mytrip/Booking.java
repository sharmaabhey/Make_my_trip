package mytrip;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Booking {
	
	
WebDriver driver;
By cancel = By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']");
By ns =By.xpath("//span[text()='Non Stop']");
	
	
	public Booking(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	
	public void cancelalert() throws Exception {
		
		
		
		try {
			
			WebElement popup=driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
			Thread.sleep(2000);
			if (popup.isDisplayed()) {
				popup.click();
			}
			
		}catch(NoSuchElementException ne) {
			System.out.println("There is no alert");
		}
		
	
		
	
	}
	//choosing non stop flights
	public void nonstop() throws Exception {
		
		
		driver.findElement(ns).click();
		Thread.sleep(2000);
	}
	//By this method it view the price of ticket and the book that
	public void  viewpriceandbook() throws Exception {
		driver.findElement(By.xpath("//span[text()='View Prices']")).click();
		String oldwin = driver.getWindowHandle();  
		
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		Thread.sleep(2000);
		for (String currwin: driver.getWindowHandles()) {
			if (oldwin != currwin) {
				driver.switchTo().window(currwin);
				
			}
		}
		
	}

}



