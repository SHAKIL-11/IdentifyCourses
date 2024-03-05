package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

//import Utilities.excelUtils;

public class webcrse2 extends Basepage{
	public JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public webcrse2(WebDriver driver){
		super(driver);
	}
	
	List<String> data1 = new ArrayList<String>();
	List<String> data2 = new ArrayList<String>();
	@FindBy(xpath="//h3[text()='Introduction to Web Development']")
	WebElement crse2;
	
	@FindBy(xpath="(//p[contains(text(),'4.7')])[2]")
	WebElement crseRating2;
	
	
	@FindBy(xpath ="//div[text()='Approx. 21 hours to complete']")
	WebElement crseduration2;
	
	@FindBy(xpath ="(//img[@class='rc-CourseraLogo'])[1]")
	WebElement crselogo;
	
	public void clkcourse2() throws IOException, InterruptedException {
		
//		List<String> data1 = new ArrayList<String>();
		System.out.println("courseName 2: "+crse2.getText());
		 data1.add(crse2.getText());
		 ExcelUtils.writeData("WebCourses",data1,0,1);
		
		
		System.out.println("courseRating2: "+crseRating2.getText());
		 data1.add(crseRating2.getText());
		 ExcelUtils.writeData("WebCourses",data1,1,1);
		 
		js.executeScript("arguments[0].click();",crse2);
		Thread.sleep(3000);
	}
	
	public void switchwindow() throws IOException {
			
		 
		Set<String> windowid1 = driver.getWindowHandles();
		    List<String> windowsidList1=  new ArrayList<String>(windowid1); 
		    String parentid = windowsidList1.get(0);
		    String childid2 = windowsidList1.get(1);
		    driver.switchTo().window(childid2);
		    
		    List<String> data2 = new ArrayList<String>();
		    System.out.println("course duration: "+crseduration2.getText());
		    data2.add(crseduration2.getText());
		    ExcelUtils.writeData("WebCourses",data2,2,1);
		  
			 driver.close();
		    driver.switchTo().window(parentid);
     	    
		
	}
	
	public void clklogo() {
   	  crselogo.click();
   }
   
   

}
