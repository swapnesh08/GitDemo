package SwapneshPatelAcademy.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Swapneshpatelacedemy.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
  protected WebDriver driver;
  public LoginPage login;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\SeleniumJava\\src\\main\\resources\\Global.properties");
		prop.load(fis);
		String browsername = prop.getProperty("Browser");
		if(browsername.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
		}
		else if(browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().window().maximize();
		}
		return driver;
		
	}
	@BeforeMethod
	public LoginPage launchApplication() throws IOException {
		driver=initializeDriver();
	 login = new LoginPage(driver);
		login.goTo();
		return login;
		
	}
//	@AfterMethod
//	//public void tearDown() {
//		 driver.close();
	//}
}
