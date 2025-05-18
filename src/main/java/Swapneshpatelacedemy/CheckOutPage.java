package Swapneshpatelacedemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwapneshPatelAcademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
 WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectcountrybox;
	
@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectcountry;
// By checkoutbtn=By.cssSelector(".btnn");
 
 @FindBy(css=".btnn")
	WebElement checkoutbtn;
 
public ConfirmationPage selectCountryText(String countryName) {
	selectcountrybox.click();
	selectcountrybox.sendKeys(countryName);
	selectcountry.click();
	Actions a = new Actions(driver);
	 a.moveToElement(checkoutbtn).build().perform();
	 return new ConfirmationPage(driver);
	 
	
	
}
public ConfirmationPage submitOrder() {
	checkoutbtn.click();
	
	return new ConfirmationPage(driver);
}



}
