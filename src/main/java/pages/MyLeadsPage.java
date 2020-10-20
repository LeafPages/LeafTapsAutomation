package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import hooks.TestNgHooks;
import io.cucumber.java.en.When;

public class MyLeadsPage extends TestNgHooks{
	

	@When("Click Create Lead Link in My Leads Page")
	public CreateLeadPage clickCreateLeadLink() {
		click(getDriver().findElement(By.linkText(getProperties().getProperty("leads_create"))));
		return new CreateLeadPage();
	}

	
	
	
}
