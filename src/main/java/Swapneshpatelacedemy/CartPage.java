package Swapneshpatelacedemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwapneshPatelAcademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
     WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproduct;
	
	 @FindBy(css=".totalRow button")
	 WebElement checkout;
	
public Boolean verifyProductDisplay(String productName) {
	Boolean match=cartproduct.stream().anyMatch(products -> products.getText().equalsIgnoreCase(productName));
  return match;
}

public CheckOutPage goToCheckoutPage() {
	checkout.click();
	
	return new CheckOutPage(driver);


}
}
