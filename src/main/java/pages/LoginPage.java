package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import hooks.TestNgHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends TestNgHooks{


	@When("Type username name in Login Page as (.*)$")
	public LoginPage typeUsername(String username) {
		type(getDriver().findElement(By.id("username")),username);
		return this;
	}

	@When("Type password in Login Page as (.*)$")
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(By.id("password")),password);
		return this;
	}

	@When("Click Login button in Login Page")
	public HomePage clickLogin() {
		click(getDriver().findElement(By.className("decorativeSubmit")));
		return new HomePage();
	}
	
	@When("Login to the application as username (.*) and password as (.*)$")
	public HomePage loginLeaftaps(String username, String password) {
		return typeUsername(username).typePassword(password).clickLogin();
	}

}
