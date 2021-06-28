package Academy.E2EProject;

//adding logs
//generating html reports
//screenshots on failure
//jenkins integration

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class ValidateNavBar extends base{
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	
	public void basePageNavigation() throws IOException //count of the arguements pass in method should equal to the count of values in each row 
	{
		
       //one is inhertance 
	   //creating object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
       	
        //compare the text from the browser with actual text...mismatch-error 
		l.getTitle().getText();
		Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
		log.info("successfully validated text msg");
		l.getAboutBardd().click(); 
		//Assert.assertFalse(false);  arguements used must be false otherwise testfails
	    Assert.assertTrue(l.getAboutBar().isDisplayed());//arguements used must be true otherwise testfails
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	}
