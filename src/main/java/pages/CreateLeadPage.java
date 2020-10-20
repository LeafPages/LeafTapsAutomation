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

public class CreateLeadPage extends TestNgHooks{
	

	@When("Type company name in Create Lead Page as (.*)$")
	public CreateLeadPage typeCompanyName(String companyName) {
		type(getDriver().findElement(By.id("createLeadForm_companyName")),companyName);
		return this;
	}

	@When("Type first name in Create Lead Page as (.*)$")
	public CreateLeadPage typeFirstName(String firstName) {
		type(getDriver().findElement(By.id("createLeadForm_firstName")),firstName);
		return this;
	}
	
	@When("Type last name in Create Lead Page as (.*)$")
	public CreateLeadPage typeLastName(String lastName) {
		type(getDriver().findElement(By.id("createLeadForm_lastName")),lastName.trim());
		return this;
	}
	
	@When("Click Create Lead button in Create Lead Page")
	public ViewLeadPage clickCreateLead() {
		click(getDriver().findElement(By.className("smallSubmit")));
		return new ViewLeadPage();
	}
}
