package mytrip;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submit {
	
	
	

	WebDriver driver;
	By mobi = By.xpath("//input[@placeholder='Mobile No']");
	By mail = By.xpath("//input[@placeholder='Email']");
	By promo =By.xpath("//span[text()='MMTSUPER']");
	By secure = By.xpath("//b[text()='Yes, Secure my trip.']");
	
	
	
	public Submit(WebDriver driver) {
		this .driver=driver;
	}
	
	public void promocode() {
		WebElement ele = driver.findElement(promo);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));		
		ele.click();
	}
	
	public void securetrip() throws Exception{
	
		try {
			WebElement secure_trip = driver.findElement(secure);
			Thread.sleep(2000);
			
			if(secure_trip.isDisplayed()) {
				secure_trip.click();
			}
			
		}catch(Exception ne) {
			System.out.println("there no any secure trip option");
		}
	}
	 public void scroll() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  
			
			WebElement web = driver.findElement(By.xpath("//input[@placeholder='Mobile No']"));
			
			js.executeScript("arguments[0].scrollIntoView();", web);
	 }
	 
	 public void  mobilenumber(String mobilenumber) {
		 WebElement mob = driver.findElement(mobi);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(mob));
		 
		 mob.sendKeys(mobilenumber);
	 }
	 
	 public void email(String email) {
		 WebElement E = driver.findElement(mail);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(E));
		 E.sendKeys(email);
	 }


}