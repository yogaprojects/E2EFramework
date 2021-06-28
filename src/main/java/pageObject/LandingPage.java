package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By signin=By.cssSelector(".theme-btn.register-btn");
	By title=By.xpath("//h2[normalize-space()='Featured Courses']");
	By aboutbardd=By.xpath("//div[@class='nav-outer clearfix']//li[@class='dropdown']");
	By aboutbar=By.xpath("//div[@class='nav-outer clearfix']//a[normalize-space()='About us']");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getAboutBardd()
	{
		return driver.findElement(aboutbardd);
	}
	public WebElement getAboutBar()
	{
		return driver.findElement(aboutbar);
	}
}


