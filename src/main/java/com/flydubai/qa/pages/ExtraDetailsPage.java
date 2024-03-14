package com.flydubai.qa.pages;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flydubai.qa.base.TestBase;

public class ExtraDetailsPage extends TestBase{
	
	@FindBy(xpath="(//div[@class='optional-baggage-weights ng-star-inserted']/div[@class='bag-weights-outer-wrap bag-weights-2 ng-star-inserted'])[1]")
	WebElement firstExtraBaggage;
	
	@FindBy(xpath="//fz-link[@class='navigateToPassengerDetails ng-star-inserted']/a/span[text()='Continue to passenger details']")
	WebElement continueToPassengerDetails;
	
	@FindBy(xpath="(//label[@id='flightDetailsAccordion'])[1]")
	WebElement flightDetails;
	
	@FindBy(xpath="(//h2[text()='Fare breakdown']//parent::div//fz-static-label[2]/label[@id='lblAmount'])[1]")
	WebElement departingFare;
	
	@FindBy(xpath="(//h2[text()='Fare breakdown']//parent::div//fz-static-label[2]/label[@id='lblAmount'])[2]")
	WebElement departingTaxSurcharge;
	
	
	@FindBy(xpath="(//h2[text()='Fare breakdown']//parent::div//fz-static-label[2]/label[@id='lblAmount'])[4]")
	WebElement returnFare;
	
	@FindBy(xpath="(//h2[text()='Fare breakdown']//parent::div//fz-static-label[2]/label[@id='lblAmount'])[5]")
	WebElement returnTaxSurcharge;
	
	
	private WebDriverWait wait;
	//Initializing the Page Objects:
		public ExtraDetailsPage(){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 50); // Initializing WebDriverWait in the constructor
	    }

	public void addExtraBaggage(){
		wait.until(ExpectedConditions.elementToBeClickable(firstExtraBaggage)).click();
	}
	
	public void continueToPassengerDetails(){
		wait.until(ExpectedConditions.elementToBeClickable(continueToPassengerDetails)).click();
	}
	
	public void clickFlightDetails(){
		wait.until(ExpectedConditions.elementToBeClickable(flightDetails)).click();
	}
	
	 public HashMap<String, String> getFlightDetails() {
	        HashMap<String, String> flightDetails = new HashMap<String, String>();

	        String departFare = wait.until(ExpectedConditions.visibilityOf(departingFare)).getText();
	        flightDetails.put("departFare", departFare);

	        String departTaxSurcharge = wait.until(ExpectedConditions.visibilityOf(departingTaxSurcharge)).getText();
	        flightDetails.put("departTaxSurcharge", departTaxSurcharge);

	        String retFare = wait.until(ExpectedConditions.visibilityOf(returnFare)).getText();
	        flightDetails.put("retFare", retFare);

	        String retTaxSurcharge = wait.until(ExpectedConditions.visibilityOf(returnTaxSurcharge)).getText();
	        flightDetails.put("retTaxSurcharge", retTaxSurcharge);
	        
	        for (Entry<String, String> entry : flightDetails.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }

	        return flightDetails;
	    }
}
