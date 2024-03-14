package com.flydubai.qa.pages;
import java.util.HashMap;
import java.util.Map.Entry;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flydubai.qa.base.TestBase;

public class SummaryFlightDetails extends TestBase{
	
	
	@FindBy(xpath="(//label[@id='lblAmount'])[4]")
	WebElement departingFare;
	
	@FindBy(xpath="(//label[@id='lblAmount'])[5]")
	WebElement departingTaxSurcharge;
	
	
	@FindBy(xpath="(//label[@id='lblAmount'])[3]")
	WebElement returnFare;
	
	@FindBy(xpath="(//label[@id='lblAmount'])[4]")
	WebElement returnTaxSurcharge;
	
	@FindBy(xpath = "//label[text()='Returning flight']")
	WebElement returningFlight;
	
	@FindBy(xpath = "//span[text()='Passengers and extras']")
	WebElement fareDetails;
	
	private WebDriverWait wait;

		public SummaryFlightDetails(){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 50); 
	    }

		public HashMap<String, String> getSummaryTaxFarDetails() throws Throwable {
			wait.until(ExpectedConditions.elementToBeClickable(fareDetails)).click();
			Thread.sleep(3000);
	        HashMap<String, String> flightDetails = new HashMap<String, String>();

	        String departFare = wait.until(ExpectedConditions.visibilityOf(departingFare)).getText();
	        flightDetails.put("departFare", departFare);

	        String departTaxSurcharge = wait.until(ExpectedConditions.visibilityOf(departingTaxSurcharge)).getText();
	        flightDetails.put("departTaxSurcharge", departTaxSurcharge);

	        wait.until(ExpectedConditions.visibilityOf(returningFlight)).click();
	        Thread.sleep(3000);
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
