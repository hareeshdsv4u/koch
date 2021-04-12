package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Spring;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class BookTicket {
	
	WebDriver driver ;
	
	ixigoPom.IxigoBooking book = PageFactory.initElements(driver, ixigoPom.IxigoBooking.class);
	
	@Test
	public  void bookTicket() throws IOException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\browsers\\chromedriver.exe");
		driver= new ChromeDriver() ;
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		String pagetitle= driver.getTitle();
		System.out.println(pagetitle);
		if (pagetitle.equals("ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels")) {
			System.out.println("Homepage is validated");
		}else{
			System.out.println("Invalid navigation to homepage");
		}			
		 
		
		  driver.findElement(By.xpath("(//*[@autocomplete='new-password'])[1]")).sendKeys("DEL - New Delhi");
		 while(!(driver.findElement(By.xpath("(//*[@class='autocompleter-scroll-cntr'])[1]")).isDisplayed())) {
			 
		 }
		 driver.findElement(By.xpath("(//*[contains(text(),'DEL - New Delhi')])[1]")).click();
		  driver.findElement(By.xpath("(//*[@autocomplete='new-password'])[2]")).sendKeys("BLR - Bengaluru");
		  while(!(driver.findElement(By.xpath("(//*[@class='autocompleter-scroll-cntr'])[2]")).isDisplayed())) {
			   
			 }
		 
		  driver.findElement(By.xpath("(//*[contains(text(),'BLR - Bengaluru')])[1]")).click();
		  
		  ReadPropFile readProp= new ReadPropFile();
	      driver.findElement(By.xpath("//*[@placeholder='Depart']")).click();
	      String a= readProp.getProperty("DepMonth");
	      String b;
	      b = driver.findElement(By.xpath("(//*[@class='rd-month-label'])[1]")).getText();
	      while(!(a.equals(b))) {
	    	  driver.findElement(By.xpath("(//*[@class='ixi-icon-arrow rd-next'])[1]")).click();
	    	  b = driver.findElement(By.xpath("(//*[@class='rd-month-label'])[1]")).getText();
	    	  
	      }
		String depDate = readProp.getProperty("DepartureDate");		
		String beforedateXpath= "//*[@data-date='";
		String afterDateXpath="']";
		String departureXpath= beforedateXpath+depDate.replace("-", "")+afterDateXpath;
		driver.findElement(By.xpath(departureXpath)).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Return']")).click();
		 String c= readProp.getProperty("RtnMonth");
	      String d;
	      d= driver.findElement(By.xpath("(//*[@class='rd-month-label'])[3]")).getText();
	      while(!(c.equals(d))) {
	    	  driver.findElement(By.xpath("(//*[@class='ixi-icon-arrow rd-next'])[2]")).click();
	    	   d= driver.findElement(By.xpath("(//*[@class='rd-month-label'])[3]")).getText();
	      }
		String rtnDate = readProp.getProperty("ReturnDate");
		String returnXpath= beforedateXpath+rtnDate.replace("-", "")+afterDateXpath;
		
		driver.findElement(By.xpath(returnXpath)).click();
			
		driver.findElement(By.xpath("(//*[@class='c-input u-v-align-middle'])[5]")).click();
		String BeforeNPxpath= "(//*[@class='number-counter'])[1]//span[";
		String NP= readProp.getProperty("NumofTravellers");
		String AfterNPxpath="]";
		String PasgNumXpath= BeforeNPxpath+NP+AfterNPxpath;
		driver.findElement(By.xpath(PasgNumXpath)).click();
	
		driver.findElement(By.xpath("(//*[@class='u-ripple'])[1]")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String ResultPage= driver.getTitle();
		System.out.println(ResultPage);
		if(ResultPage.equals("ixigo - Flights, IRCTC Train Booking, Bus Booking, Air Tickets & Hotels")) {
			System.out.println("Resultpage is validated");
		}else{
			System.out.println("Invalid result page");
		
		}
		Thread.sleep(25000);
		try {
			while(driver.findElement(By.xpath("//*[@class='prdctn-a roundtrip disable']")).isDisplayed()) {
			
			}
		}catch(Exception e) {
			
		}
	    driver.findElement(By.xpath("//*[@class='more-fltrs u-link']/span")).click();
	    
		List<WebElement> ele= driver.findElements(By.xpath("//*[@class='ixi-icon-tick check-icon']"));
		for(WebElement e:ele) {
			boolean K=e.isDisplayed();
			Assert.assertEquals(K, true);
			e.click();
			Thread.sleep(500);
			boolean L=e.isEnabled();
			Assert.assertEquals(L, true);
			e.click();
			Thread.sleep(500);
			boolean M=e.isSelected();
			Assert.assertEquals(M, false);
		}
		System.out.println("Verified check boxes");
		 List<WebElement> slot=driver.findElements(By.xpath("//*[@class='u-ripple']"));
		 for (int i=1;i<slot.size();i++) {
		 boolean P = slot.get(i).isDisplayed();
		 Assert.assertEquals(P, true);
		 slot.get(i).click();
		 Thread.sleep(500);
		 boolean Q  = slot.get(i).isEnabled();
		 Assert.assertEquals(Q, true);
		 slot.get(i).click();
		 Thread.sleep(500);
		 boolean R= slot.get(i).isSelected();
		 Assert.assertEquals(R, false);
		 }
		 driver.findElement(By.xpath("(//*[@class='ixi-icon-tick check-icon'])[1]")).click();
				 
		 WebElement element = driver.findElement(By.xpath("//*[text()='APPLY']"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element);
		
		 List<WebElement> priceEleFromDelToBlr = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[1]//*[@class='price']//span[2]"));
		 List<WebElement> flightNameFromDelToBlr = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[1]//*[@class='airline-text']/div"));
		 List<WebElement> flightDepTimeFromDelToBlr = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[1]//*[@class='time-group']/div[@class='time']"));
		 List<WebElement> priceEleFromBlrToDel = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[2]//*[@class='price']//span[2]"));
		 List<WebElement> flightNameFromBlrToDel = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[2]//*[@class='airline-text']/div"));
		 List<WebElement> flightDepTimeFromBlrToDel = driver.findElements(By.xpath("(//*[@class='result-col-inner'])[2]//*[@class='time-group']/div[@class='time']"));
		
		 ArrayList<String> flightListDelTobgr = new ArrayList<String>();
		 ArrayList<String> flightDepFrmDelTobgr = new ArrayList<String>();
		 for(int i=0;i<priceEleFromDelToBlr.size();i++) {
			 if(Integer.parseInt(priceEleFromDelToBlr.get(i).getText()) <= 7000) {
				 flightListDelTobgr.add(flightNameFromDelToBlr.get(i).getText());
				 flightDepFrmDelTobgr.add(flightDepTimeFromDelToBlr.get(i*2).getText());
				 
			 }
		 }
		 
		 System.out.println("Flights avialable from Delhi to Bangalore under 7000 are:");
		 System.out.println("FlightName FlightNumber FlightDepTime");
			 for(int i=0;i<flightListDelTobgr.size();i++) {
				 System.out.println(flightListDelTobgr.get(i)+" "+flightDepFrmDelTobgr.get(i));
		 }
			 
			 ArrayList<String> flightListBlrToDel = new ArrayList<String>();
			 ArrayList<String> flightDepFrmBlrToDel = new ArrayList<String>();
			 for(int i=0;i<priceEleFromBlrToDel.size();i++) {
				 if(Integer.parseInt(priceEleFromBlrToDel.get(i).getText()) <= 7000) {
					 flightListBlrToDel.add(flightNameFromBlrToDel.get(i).getText());
					 flightDepFrmBlrToDel.add(flightDepTimeFromBlrToDel.get(i*2).getText());
				 }
			 }
			 
			 System.out.println("Flights avialable from Bangalore to Delhi under 7000 are:");
			 System.out.println("FlightName FlightNumber FlightDepTime");
				 for(int i=0;i<flightListBlrToDel.size();i++) {
					 System.out.println(flightListBlrToDel.get(i)+" "+flightDepFrmBlrToDel.get(i));
			 }
	}
	
	

}
