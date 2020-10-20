package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.HomePage;
import pages.LoginPage;

public class TC001_CreateLead extends TestNgHooks{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001Login";
		testDescription = "Login to Leaftaps";
		category = "smoke";
		authors = "Babu";  
		dataSheetName = "TC001";
		nodes = "Leads";
	}
	

	@Test(dataProvider="fetchData")
	public void createLead(String companyName, String firstName, String lastName) {
		new HomePage()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickCreateLeadLink()
		.typeCompanyName(companyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLead()
		.verifyTitle();
	}
	
	
}
