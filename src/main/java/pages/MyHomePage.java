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

public class MyHomePage extends TestNgHooks{
	

	@When("Click Leads Tab in My Home Page")
	public MyLeadsPage clickLeadsTab() {
		click(getDriver().findElement(By.linkText(getProperties().getProperty("home_leads"))));
		return new MyLeadsPage();
	}

	
	
	
}
