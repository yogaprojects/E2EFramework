package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
        
	    
	    public WebDriver driver;//create driver object once in global ..we can use in entire
	    public Properties prop;
	    public WebDriver initializeDriver() throws IOException  //when we give return driver in last step here void changes to WebDriver
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Apex Predator\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			// Set the driver path
			System.setProperty("webdriver.chrome.driver", "D:\\Compressed\\chromedriver.exe");
			
			// Start chrome Session
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Compressed\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Compressed\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver; //whoever want this method can use coz we returned a driver if not cant use
	}
	    
	    public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	    {
	      TakesScreenshot ts=(TakesScreenshot)driver;
	      File source= ts.getScreenshotAs(OutputType.FILE);
	      String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	      FileUtils.copyFile(source,new File(destinationFile));
	      return destinationFile;
	    }
	    
	    
	    
	    
}
