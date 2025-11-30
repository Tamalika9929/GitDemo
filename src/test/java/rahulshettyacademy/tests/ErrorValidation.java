package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


public class ErrorValidation extends BaseTest{

	
	@Test(groups= {"ErrorHandling"})
	public void submitOrder() throws IOException, InterruptedException
	{
		
		//String productName="ZARA COAT 3";
		landingPage.loginApplication("tom@cook.com", "Abcd12345");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());;
		
	}

	@Test
	public void ProductErrorValidation() throws InterruptedException {
		String productName="ZARA COAT 33";
		ProductCatalogue productCatalogue=landingPage.loginApplication("tom@cook.com", "Abcd1234");
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();

		Boolean match=cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
	}
}
