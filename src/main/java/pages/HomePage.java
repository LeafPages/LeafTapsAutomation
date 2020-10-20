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

public class HomePage extends TestNgHooks{
	
	
	@When("The logout is clicked")
	public LoginPage clickLogOut() {
		click(getDriver().findElement(By.className("decorativeSubmit")));
		return new LoginPage();
	}

	@When("CRM is clicked")
	public MyHomePage clickCRMSFA() {
		click(getDriver().findElement(By.linkText("CRM/SFA")));
		return new MyHomePage();
	}

	
	
	
}
