package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WINDOWS);
		//cap.setPlatform(Platform.LINUX);
		//cap.setPlatform(Platform.MAC);
		
		cap.setBrowserName("chrome");
		
		URL HubURL = new URL("http://localhost:4444/wd/hub");
		
		WebDriver driver = new RemoteWebDriver(HubURL,cap);
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// Step1. Click  on the Login Link
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		driver.close();

	}

}

