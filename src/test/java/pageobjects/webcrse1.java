package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;


public class webcrse1 extends Basepage {
	public JavascriptExecutor js= (JavascriptExecutor)driver;

	public webcrse1(WebDriver driver) {
		super(driver);
		
	}
	
	List<String> data = new ArrayList<String>();
	
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	WebElement searchbox;
	
	@FindBy(xpath="//*[text()='Language']")
	WebElement scrll;
	
	@FindBy(xpath="(//input[@type='checkbox'])[6]")
	WebElement clkeng ;
	
	@FindBy(xpath="//*[text()='Level']")
	WebElement scrll2;
	
	@FindBy(xpath="//span[text()='Beginner']")
	WebElement beginner;
	
	@FindBy(xpath="//h3[normalize-space()='Meta Front-End Developer']")
	WebElement crse1;
	
	@FindBy(xpath = "(//p[contains(text(),'4.7')])[1]")
	WebElement crseRating;
	
	@FindBy(xpath= "(//h3[normalize-space()='Meta Front-End Developer'])[1]")
	WebElement clkcrse1;
	
	@FindBy(xpath="(//div[text()='7 months at 6 hours a week'])[2]")
	WebElement crseduration;
	
	
	public void enterSearchbox(String txt) {
		searchbox.sendKeys(txt);
		searchbox.sendKeys(Keys.ENTER);
	}
	
	public void clkcheckbox() throws InterruptedException {
		
	    js.executeScript("arguments[0].scrollIntoView",scrll);
		clkeng.click();
		js.executeScript("arguments[0].scrollIntoView",scrll2);
		beginner.click();
		 Thread.sleep(3000);

		
	}
	  
	public void clkcourse1() throws IOException, InterruptedException {
//		List<String> data = new ArrayList<String>();
		 System.out.println("courseName 1: "+crse1.getText());
		 data.add(crse1.getText());
		 ExcelUtils.writeData("WebCourses",data,0,0);
		 
		
		 System.out.println("courseRating1: "+crseRating.getText());
		 js.executeScript("arguments[0].click();",clkcrse1);
		 data.add(crseRating.getText());
		 ExcelUtils.writeData("WebCourses",data,1,0);
		
		 
		 Set<String> windowid = driver.getWindowHandles();
		    List<String> windowsidList = new ArrayList<String>(windowid);
		    String parentid = windowsidList.get(0);
		    String childid = windowsidList.get(1);
		    driver.switchTo().window(childid);
		  
		    String crseduration= driver.findElement(By.xpath("(//div[text()='7 months at 6 hours a week'])[2]")).getText();
		    System.out.println("course duration: "+crseduration);
		    data.add(crseduration);
		    ExcelUtils.writeData("WebCourses",data,2,0);
		   
		    driver.close();
		
		driver.switchTo().window(parentid);
		Thread.sleep(3000);
	}


}
