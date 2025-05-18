package SwapneshPatelAcademy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import SwapneshPatelAcademy.testComponents.BaseClass;
import Swapneshpatelacedemy.ProductCatelogue;
import junit.framework.Assert;


public class ErrorValidationTest extends BaseClass {
	@Test
	public void submitOrder() throws IOException {
		String productName= "IPHONE 13 PRO";
		//String actual="THANKYOU FOR THE ORDER.";
		
		
	
		ProductCatelogue productcat =	login.loginApplication("swapneshhessonite@gmail.com", "1234");
		Assert.assertEquals(" Incorrect email or password.",login.errorvalidation());
		
		
	}
}
