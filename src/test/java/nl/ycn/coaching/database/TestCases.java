package nl.ycn.coaching.database;

import nl.ycn.coaching.database.AppUserRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCases {
	
	private WebDriver driver;
	private AppUserRepository appUserRepository;
	
	
	public TestCases (WebDriver driver) {
		this.driver = driver;
	}
	
	public void Login (String usernameString, String passwordString) throws InterruptedException {
		WebElement username = driver.findElement (By.name ("username"));
		username.sendKeys (usernameString);
		
		WebElement password = driver.findElement (By.name ("password"));
		
		password.sendKeys (passwordString);
		
		WebElement login = driver.findElement (By.cssSelector ("button"));
		login.click ();
	}
	
	public void ChangeAccountSettings (String passwordString, String newPasswordString) throws InterruptedException {
		
		WebElement newPassword = driver.findElement (By.name ("new_password"));
		newPassword.sendKeys (newPasswordString);
		WebElement confirmPassword = driver.findElement (By.name ("confirm_password"));
		confirmPassword.sendKeys (newPasswordString);
		WebElement changePassword = driver.findElement (By.cssSelector ("button"));
		changePassword.click ();
	}
	
	
	public void Logout () {
		WebElement logout = driver.findElement (By.linkText ("Logout"));
		logout.click ();
	}
	
	public boolean CheckActivation () {
		try {
			WebElement redirectLogin = driver.findElement (By.name ("redirect_login"));
		} catch (NoSuchElementException e) {
			return true;
		}
		return false;
	}
}