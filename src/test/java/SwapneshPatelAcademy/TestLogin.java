package SwapneshPatelAcademy;

import java.awt.Window;
import java.io.IOException;
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
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import SwapneshPatelAcademy.testComponents.BaseClass;
import Swapneshpatelacedemy.CartPage;
import Swapneshpatelacedemy.CheckOutPage;
import Swapneshpatelacedemy.ConfirmationPage;
import Swapneshpatelacedemy.LoginPage;
import Swapneshpatelacedemy.ProductCatelogue;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestLogin extends BaseClass  {
     @Test
	public void submitOrder() throws IOException {
		String productName= "IPHONE 13 PRO";
		//String actual="THANKYOU FOR THE ORDER.";
		
		
	
		ProductCatelogue productcat =	login.loginApplication("swapneshhessonite@gmail.com", "Cbr@7733");
		List<WebElement> products=productcat.getProductList();
		productcat.addProductToCart(productName);
		CartPage cartpage=	productcat.goToCart();
		boolean match=  cartpage.verifyProductDisplay(productName);
	  Assert.assertTrue(match);
	  CheckOutPage checkout=cartpage.goToCheckoutPage();
	  checkout.selectCountryText("india");
      
	  ConfirmationPage confirm = checkout.submitOrder();
	 String confirmMessage= confirm.getConfirmationMessage();
	  
	  
     Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    
	}
}