package mytrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	
	WebDriver driver;
	By fromcity = By.xpath("//label[@for='fromCity']");
	By st =By.xpath("//span[@class='langCardClose']");
	By fromc = By.xpath("//input[@placeholder='From']");
	By too = By.xpath("//input[@placeholder='To']");
	By date = By.xpath("//p[text()='''+ s +''']");
	By searching =By.xpath("//a[text()='Search']");
	

	
	public Home(WebDriver driver) {
		this.driver=driver;
	}
	//it cancel the first popup
	public void cancelingpopup() {
		driver.findElement(fromcity).click();
		
		driver.findElement(st).click();
		
	}
	//it is for choosing starting location
	public void from(String from) throws Exception {
		WebElement bgb = driver.findElement(fromc);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(bgb));
		bgb.click();
		Thread.sleep(1000);
		bgb.sendKeys(from);
		Thread.sleep(2000);
		bgb.sendKeys(Keys.ARROW_DOWN);
		bgb.sendKeys(Keys.ENTER);
	}
	//it is for choosing final destination
	public void to(String to) throws Exception {
		WebElement be = driver.findElement(too);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(be));
		be.click();
		Thread.sleep(1000);
		be.sendKeys(to);
		Thread.sleep(2000);
		be.sendKeys(Keys.ARROW_DOWN);
		be.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	//it is for setting up the date
	public void Setdate(String s  ) throws Exception  {
		String get_month = driver.findElement(By.xpath("(//div[@role='heading'])[2]")).getText();
		System.out.println(get_month);
		Thread.sleep(2000);
		String date = s;
		String splitter[]= date.split(",");
		String day = splitter[0];
		System.out.println(day);
		String monthandyear =splitter[1];
		System.out.println(monthandyear);
		while(!get_month.equals(monthandyear)) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			Thread.sleep(3000);
			get_month = driver.findElement(By.xpath("(//div[@role='heading'])[2]")).getText();
			
			System.out.println(get_month);
		}
		
		String xpath = "(//div[@class='DayPicker-wrapper']//div[@class='DayPicker-Month'])[2]//div[@class='DayPicker-Day']//following::p[text()='"+day+"']";
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(2000);
		

		
		
		
		
	
		
	}
	//this method helps to click on search button
	public void search() {
		driver.findElement(searching).click();
	}
}



