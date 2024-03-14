package com.flydubai.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flydubai.qa.base.TestBase;

public class FlightSelection extends TestBase{
	
	@FindBy(xpath="(//img[@class='selectDropDownImageFlight ng-star-inserted'])[1]")
	WebElement departFirstFare;
	
	@FindBy(xpath="(//div[@class='fare-brand-column'])[2]//span[text()='SELECT']")
	WebElement departFareBrandValue;
	
	@FindBy(xpath="(//div[@class='flex-basis-css return-journey-page ng-star-inserted']//div[@class='flight-accord-icon ng-star-inserted'])[1]")
	WebElement returnFirstFare;
	
	@FindBy(xpath="(//div[@class='returnOverlayBckgrnd returnOverlayBckgrndAftrClick']//span[text()='SELECT'])[2]")
	WebElement returnFareBrandValue;
	
	private WebDriverWait wait;
	//Initializing the Page Objects:
		public FlightSelection(){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 50); // Initializing WebDriverWait in the constructor
	    }
	
	public void selectDepartingFlight() {
		wait.until(ExpectedConditions.elementToBeClickable(departFirstFare)).click();
		wait.until(ExpectedConditions.elementToBeClickable(departFareBrandValue)).click();
	}
	public void selectReturningFlight() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(returnFirstFare)).click();
		wait.until(ExpectedConditions.elementToBeClickable(returnFareBrandValue)).click();
	}

}
