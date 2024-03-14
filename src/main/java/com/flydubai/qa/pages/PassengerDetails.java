package com.flydubai.qa.pages;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flydubai.qa.base.TestBase;

public class PassengerDetails extends TestBase{
	
	@FindBy(id ="First_Name")
	WebElement firstName;
	
	@FindBy(id ="Last_Name")
	WebElement lastName;
	
	@FindBy(id ="Email_Address")
	WebElement emailAddress;
	
	@FindBy(xpath ="//mat-radio-button[@id='Male.Text']")
	WebElement maleGender;
	
	@FindBy(xpath = "(//img[@src='../assets/images/accord-down-arrow.svg'])[2]")
	WebElement countryCode;
	
	@FindBy(id ="Mobile_Number")
	WebElement mobileNumber;
	
	@FindBy(xpath = "(//span[text()='Review booking'])[1]")
	WebElement reviewBooking;
	
	private WebDriverWait wait;

		public PassengerDetails(){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 50); 
	    }

	public void enterFirstName(String firstname){
		wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname){
		wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(lastname);
	}
	
	public void enterEmailAddress(String email){
		wait.until(ExpectedConditions.elementToBeClickable(emailAddress)).sendKeys(email);
	}
	
	public void clickCountryCode(){
		wait.until(ExpectedConditions.elementToBeClickable(countryCode)).click();
	}
	
	  public void scrollToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    public void scrollToSelector() {
	    	String indiaCode="//span[text()='+91']";
	    	
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(indiaCode)));
	        scrollToElement(element);
	        element.click();
	    }
	
	public void enterMobileNumber(String phoneNo){
		wait.until(ExpectedConditions.elementToBeClickable(mobileNumber)).sendKeys(phoneNo);
	}
	
	public void clickReviewBooking(){
		wait.until(ExpectedConditions.elementToBeClickable(reviewBooking)).click();
	}
	
	public void selectGender(){
		wait.until(ExpectedConditions.elementToBeClickable(maleGender)).click();
	}
	
}
