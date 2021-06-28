package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base{
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	

	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password,String text) throws IOException //count of the arguements pass in method should equal to the count of values in each row 
	{
		driver.get(prop.getProperty("url"));
       //one is inhertance 
	   //creating object to that class and invoke methods of it
		LandingPage l=new LandingPage(driver);
        l.getLogin().click();  //driver.findElement (Bycss)	
        LoginPage lp=new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        
        log.info(text);
       // System.out.println(text);
        lp.getLogin().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//rows stands for hw many different data types should run
		//columns stands for hw many values for test
		Object[][] data=new Object[2][3]; //2rows regular user,restricted user //3 col-un,pw,print regular/rest user
		//0th row                         //Array size is 2 means index starts from 0,1 
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="non-restricted user";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456789";
		data[1][2]="restricted user";
		
		return data;
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	
	
	
}
