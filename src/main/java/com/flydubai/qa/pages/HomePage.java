package com.flydubai.qa.pages;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flydubai.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="(//input[@id='airport-origin'])[1]")
	WebElement from;
	
	@FindBy(xpath="(//input[@name='airport-destination'])[1]")
	WebElement to;

	@FindBy(xpath = "//button[normalize-space()='Accept All']")
	WebElement acceptCookies;
	
	@FindBy(xpath="//li[@data-name='dubai']")
	WebElement dubai;
	
	@FindBy(xpath="//li[@data-name='Muscat']")
	WebElement muscat;
	
	@FindBy(xpath = "(//input[@value='Search'])[1]")
	WebElement search;
	
	private WebDriverWait wait;
	//Initializing the Page Objects:
		public HomePage(){
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 30); // Initializing WebDriverWait in the constructor
	    }
	
	public void acceptCookies() {
		
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookies)).click();
	}
	public void enterFrom(String fromLocation) throws Exception{
		wait.until(ExpectedConditions.visibilityOf(from)).sendKeys(fromLocation);
		wait.until(ExpectedConditions.visibilityOf(dubai)).click();
	}
	public void enterTo(String toLocation){
		wait.until(ExpectedConditions.visibilityOf(to)).sendKeys(toLocation);
		wait.until(ExpectedConditions.visibilityOf(muscat)).click();
	}
	
	public void clickSearch(){
		wait.until(ExpectedConditions.visibilityOf(search)).click();
	}

	  public int getDayAfterDays(int days) {
	        Calendar today = Calendar.getInstance();
	        today.add(Calendar.DAY_OF_MONTH, days);
	        int dayAfterDays = today.get(Calendar.DAY_OF_MONTH);
	        
	        return dayAfterDays;
	    }
	  
	  public void selectDate(int days) {
		  int day = this.getDayAfterDays(days);
		  WebElement element = driver.findElement(By.xpath("(//div[contains(text(),'" + day + "')])[1]"));
		  element.click();
		  
	  }
}
