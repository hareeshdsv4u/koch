package ixigoPom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IxigoBooking {
	WebDriver driver;
	
	
	@FindBy(xpath = "(//*[@class='c-input-cntr'])[1]")
	public WebElement fromSearch;
	
	@FindBy(xpath = "(//*[@class='c-input-cntr'])[2]")
	public WebElement ToSearch;
	
	@FindBy(xpath = "(//*[@class='c-input-cntr'])[3]")
	public WebElement DepartureDate;
	
	@FindBy(xpath = "(//*[@class='c-input-cntr'])[4]")
	public WebElement ReturnDate;
	
	@FindBy(xpath = "(//*[@class='c-input-cntr'])[5]")
	public WebElement TravelNum;
	
	@FindBy(xpath = "(//*[@class='u-ripple'])[1]")
	public WebElement SearchTab;
}
