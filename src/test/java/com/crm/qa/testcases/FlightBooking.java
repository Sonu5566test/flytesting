package com.crm.qa.testcases;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.flydubai.qa.pages.HomePage;
import com.flydubai.qa.pages.PassengerDetails;
import com.flydubai.qa.pages.SummaryFlightDetails;
import com.flydubai.qa.base.TestBase;
import com.flydubai.qa.pages.ExtraDetailsPage;
import com.flydubai.qa.pages.FlightSelection;

public class FlightBooking extends TestBase {
	HomePage homePage;
	FlightSelection flightSelection;
	ExtraDetailsPage extraDetail;
	PassengerDetails passengerDetails;
	SummaryFlightDetails summaryDetails;

	String expectedDepartFare;
	String expectedDepartTaxSurcharge;
	String expectedRetFare;
	String expectedRetTaxSurcharge;
	
	public FlightBooking() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		homePage = new HomePage();
		flightSelection = new FlightSelection();
		extraDetail = new ExtraDetailsPage();
		passengerDetails = new PassengerDetails();
		summaryDetails = new SummaryFlightDetails();
	}

	@Test(priority = 1)
	@Parameters({"from","to"})
	public void SelectDepartureReturnTest(String from, String to) throws Throwable {
		homePage.acceptCookies();
		homePage.enterFrom(from);
		homePage.enterTo(to);
		Thread.sleep(2000);
		homePage.selectDate(3); // adding a date which is +3 days from current date
		Thread.sleep(2000);
		homePage.selectDate(6); // adding a date which is +6 days from current date
		homePage.clickSearch();
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	public void FlightSelectionPageTest() throws Throwable {
		flightSelection.selectDepartingFlight();
		Thread.sleep(10000);
		flightSelection.selectReturningFlight();
	}
	
	@Test(priority = 3)
	public void AddExtraBaggageAndGetFlightDetailsTest() throws Throwable {
		extraDetail.addExtraBaggage();
		extraDetail.clickFlightDetails();
		/* Fetching Flight Fare and Tax Surcharge from Flight details tab */
		HashMap<String, String> getflightDetails = extraDetail.getFlightDetails();
		expectedDepartFare = getflightDetails.get("departFare");
		expectedDepartTaxSurcharge = getflightDetails.get("departTaxSurcharge");
		expectedRetFare = getflightDetails.get("retFare");
		expectedRetTaxSurcharge = getflightDetails.get("retTaxSurcharge");
		extraDetail.continueToPassengerDetails();
		Thread.sleep(6000);
	}
	
	@Test(priority = 4)
	@Parameters({"firstName","lastName","emailAddress","phoneNumber"})
	public void ReviewBookingTest(String firstName,String lastName,String email,String phoneNo) throws Throwable {
		passengerDetails.enterFirstName(firstName);
		passengerDetails.enterLastName(lastName);
		passengerDetails.enterEmailAddress(email);
		passengerDetails.selectGender();
		passengerDetails.clickCountryCode();
		passengerDetails.scrollToSelector();
		passengerDetails.enterMobileNumber(phoneNo);
		passengerDetails.clickReviewBooking();
	}

	/* Validating Amount In Summary page with the amount fetched from Fligh Details tab */
	@Test(priority = 5)
	public void ValidateFlightSummaryDetailsTest() throws Throwable {
		HashMap<String, String> flightDetails = summaryDetails.getSummaryTaxFarDetails();
		Assert.assertEquals(flightDetails.get("departFare"), expectedDepartFare);
		Assert.assertEquals(flightDetails.get("departTaxSurcharge"), expectedDepartTaxSurcharge);
		Assert.assertEquals(flightDetails.get("retFare"), expectedRetFare);
		Assert.assertEquals(flightDetails.get("retTaxSurcharge"), expectedRetTaxSurcharge);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
