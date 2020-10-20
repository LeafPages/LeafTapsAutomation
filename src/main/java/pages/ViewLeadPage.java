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

public class ViewLeadPage extends TestNgHooks{
	
	
	@When("Verify the Page Title")
	public ViewLeadPage verifyTitle() {
		verifyExactTitle(getProperties().getProperty("view_title"));
		return this;
	}

	
	
}
