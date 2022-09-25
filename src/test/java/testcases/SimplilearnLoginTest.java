package testcases;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.util.CellReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
@Listeners(ListenerExample.class)
public class SimplilearnLoginTest extends BaseClass{
	
	//eact method heere we treat as test case
	
	@Test
	public void Test1() {
		
		test.log(LogStatus.INFO, "Test1 Started");
		//LoginPage lp = new LoginPage(driver);
		LoginPage lp=new LoginPage(driver);
		lp.Login("abc@xyz.com","Abc@1234");
		
		//Step6: Validate the error message on screen
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid";
		
		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(ActError, ExpError);
			
	}
	
	@Test
	@Parameters({"uname","pwd"})
	public void Test2(String UserName, String Password) {
		test.log(LogStatus.INFO, "Test2 Started");
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName,Password);
	}
	
	@Test
	public void Test3() {
		
		test.log(LogStatus.INFO, "Test3 Started");
		
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName,Password);
	}
	
	

}
