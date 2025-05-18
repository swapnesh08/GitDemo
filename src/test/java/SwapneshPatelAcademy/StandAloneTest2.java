package SwapneshPatelAcademy;

import java.awt.Window;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		String itemnames= "BANARSI SAREE";
		String actual="THANKYOU FOR THE ORDER.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("swapneshhessonite@gmail.com");
		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Cbr@7733");
		driver.findElement(By.id("login")).click();
		
		
		List<WebElement> itemlist=driver.findElements(By.cssSelector(".mb-3"));
	WebElement product=	 itemlist.stream().filter(item->
		 item.findElement(By.cssSelector(".card-body b"))
		 .getText().equals(itemnames)).findFirst().orElse(null);
	
	product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animation")));
driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();

List<WebElement> checkoutlist=driver.findElements(By.cssSelector(".cartSection h3"));

Boolean b=checkoutlist.stream().anyMatch(products -> products.getText().equalsIgnoreCase(itemnames));

  Assert.assertTrue(b);
  driver.findElement(By.cssSelector(".totalRow button")).click();
  
 WebElement text= driver.findElement(By.cssSelector("[placeholder='Select Country']"));
 text.click();
 text.sendKeys("india");
 
 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
 Actions a = new Actions(driver);
 a.moveToElement(driver.findElement(By.cssSelector(".btnn"))).build().perform();
 
	 driver.findElement(By.cssSelector(".btnn")).click();
String order =	driver.findElement(By.cssSelector(".hero-primary")).getText();
 
 System.out.println(order);
 Assert.assertEquals(order, actual);
  
  
		 
		 
	

	}
}