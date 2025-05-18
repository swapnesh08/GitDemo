package SwapneshPatelAcademy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String[] itemnames= {"QWERTY","BANARSI SAREE"};
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("input#userEmail")).sendKeys("swapneshhessonite@gmail.com");
		driver.findElement(By.cssSelector("input#userPassword")).sendKeys("Cbr@7733");
		driver.findElement(By.id("login")).click();
		
		
		List<WebElement> itemlist=driver.findElements(By.cssSelector(".container b"));
		int j=0;
		for(int i=0; i<itemlist.size(); i++) {
		String list=	 itemlist.get(i).getText();
		System.out.println(list);
		List names = Arrays.asList(itemnames);
			 if(names.contains(list)) {
		j++;
			
	WebElement footer=	 driver.findElement(By.cssSelector("section[id='products']"));
	footer.findElements(By.xpath("//div[@class='card-body']/button[2]")).get(i).click();
	Thread.sleep(5000);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-body']/button[2]")));
		// driver.findElements(By.xpath("//div[@class='card-body']/button[2]")).get(i).click();	 
			if(j==2) {
				break;
			}
			 }
		}
		

	}

}
