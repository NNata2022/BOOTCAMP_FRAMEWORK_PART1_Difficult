package com.tutorialsninja.qa.TestCase_Difficult;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.SearchPage;

public class SearchPage_Test {
	public WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://tutorialsninja.com/demo/");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
     driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
	 
	}
	 @Test
	    public void testAddProductToCartAndVerify() throws Exception {
		 SearchPage searchpage = new SearchPage(driver);
		 
		 searchpage. searchProduct("HP");
		// searchpage.addProductToCart();
		 //searchpage.proceedToCheckout();
	      String expectedProductName = "HP LP3065" ;
	        boolean isProductCorrect = searchpage.isProductInCheckout(expectedProductName);
	        System.out.println("Is the correct product displayed on the checkout page? " + isProductCorrect);

	       // Assert.assertTrue(isProductCorrect, "Incorrect product displayed on the checkout page");
           Thread.sleep(3000);
	        String actualWarningMessage = driver.findElement(By.xpath("//h2[text()='Products meeting the search criteria']")).getText();
			String expectedWarningMessage = "Products meeting the search criteria";
			System.out.println(actualWarningMessage);
			Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
			searchpage.addProductToCart();
	       // System.out.println("Is the correct product displayed on the checkout page? " + isProductCorrect);

	        //Assert.assertTrue(isProductCorrect, "Incorrect product displayed on the checkout page");
	       
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
}
