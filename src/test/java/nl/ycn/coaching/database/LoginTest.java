package nl.ycn.coaching.database;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	@Test
	public void testLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("localhost:8080");
		
		// Login in the trainee environment
		String traineeUsername = "alex";
		String traineePassword = "hallo";
		String traineeUpdatedPassword = "Welkom01!!";
		
		TestCases traineeLoginTest = new TestCases (driver);
		traineeLoginTest.Login (traineeUsername, traineePassword);
		if (!traineeLoginTest.CheckActivation ()) {
			traineeLoginTest.ChangeAccountSettings (traineePassword, traineeUpdatedPassword);
			System.out.println ("not activated");
//			traineeLoginTest.Logout ();
		}
		
//		traineeLoginTest.Logout ();
		
//		AppUser user = appUserRepository.findByUsername ("alex");
//		Assert.assertEquals("alex", user.getUsername ());
//		System.out.println (user.getFirstName ());
		//        traineeLoginTest.CheckActivation ();
		
		
		// Testing the HR environment
		//        String HrUsername = "wouter";
		//        String HrPassword = "hallo";
		//        String HrUpdatedPassword = "Welkom01!!";
		//
		//        TestCases HrLoginTest = new TestCases (driver);
		//        HrLoginTest.FirstLogin (HrUsername, HrPassword, HrUpdatedPassword);
		//        HrLoginTest.Logout ();
		//        HrLoginTest.Login (HrUsername, HrUpdatedPassword);
		
		//        WebElement peppage = driver.findElement(By.linkText ("Personal Education Plan"));
		//        peppage.click ();
		
		//        AddHardskillTest addSoftskillTest = new AddHardskillTest (driver);
		//        addSoftskillTest.AddSoftskill ();
		
		//        AddHardskillTest addHardskillTest = new AddHardskillTest (driver);
		//        addHardskillTest.AddHardskill ();
		//
		//
		//        Thread.sleep (1000);
		//        WebElement skillselect = driver.findElement(By.id("clicksoftskill"));
		//        skillselect.click ();
		//
		//
		//        driver.quit();
		
		
	}
}
