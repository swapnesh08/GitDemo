package Swapneshpatelacedemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwapneshPatelAcademy.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	private static final String CartPage = null;

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#userEmail")
	WebElement usermail;
	
	@FindBy(css="input#userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatelogue loginApplication(String user , String password) {
		
		usermail.sendKeys(user);
		userpassword.sendKeys(password);
		submit.click();
		ProductCatelogue productcat = new ProductCatelogue(driver);
		return productcat;
	}

	
	public void goTo (){
		 driver.get("https://rahulshettyacademy.com/client");
		 
	}
	
	public String errorvalidation() {
		waitForWebElementToAppear(errorMessage);
		 return errorMessage.getText();
	}

}
