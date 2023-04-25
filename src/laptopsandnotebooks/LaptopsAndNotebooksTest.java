package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

//1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
     @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

//1.1 Mouse hover on Laptops & Notebooks Tab.and click

mouseHoverClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

//1.2 Click on “Show All Laptops & Notebooks”

         clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

//            1.3 Select Sort By "Price (High > Low)"
         WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
         Select select = new Select(dropDown);
         select.selectByVisibleText("Price (High > Low)");


//            1.4 Verify the Product price will arrange in High to Low order.


         List<WebElement> beforeSelection = driver.findElements(By.xpath("//p[@class='price']"));
         List<String> beforeSelection1 = new ArrayList<>();
         for (WebElement list: beforeSelection) {
             beforeSelection1.add(String.valueOf(list));
         }
         List<WebElement> afterSelection = driver.findElements(By.xpath("//p[@class='price']"));
         List<String> afterSelection1 = new ArrayList<>();
         for (WebElement list1: afterSelection) {
             afterSelection1.add(String.valueOf(list1));
         }

         Collections.sort(beforeSelection1);
         Collections.reverse(beforeSelection1);
         Assert.assertEquals(afterSelection1.toString(),beforeSelection1.toString());
     }





//2. Test name verifyThatUserPlaceOrderSuccessfully()

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{
        //2.1 Mouse hover on Laptops & Notebooks Tab and click


        mouseHoverClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

//2.2 Click on “Show All Laptops & Notebooks”

        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

//  2.3 Select Sort By "Price (High > Low)"
        WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");

        //2.4 Select Product “MacBook”

        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));



//2.5 Verify the text “MacBook”
        String expectedMacBook= "MacBook";
        String actualMacBook= getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals("Error Message",expectedMacBook,actualMacBook);




        //2.6 Click on ‘Add To Cart’ button

        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”

        WebElement elementMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actual = elementMessage.getText();
        System.out.println(actual);
        String expected = "Success: You have added MacBook to your shopping cart!";

        System.out.println(expected);
        boolean message = actual.contains(expected.trim());
        Assert.assertTrue(message);
       // Thread.sleep(2000);


// 2.8 Click on link “shopping cart” display into success message

clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

     //   2.9 Verify the text "Shopping Cart"
        String expectedCart= "Shopping Cart  (0.00kg)";
        String actualCart= getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Error Message",expectedCart,actualCart);

      //  2.10 Verify the Product name "MacBook"


        String expectedName= "MacBook";
        String actualName= getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Error Message",expectedName,actualName);

//2.11 Change Quantity "2"


        WebElement element = driver.findElement(By.cssSelector("input[value='1']"));
        element.clear();
        sendTextToElement(By.cssSelector("input[value='1']"), "2");
        Thread.sleep(2000);



//2.12 Click on “Update” Tab


clickOnElement(By.xpath("//button[@type='submit']"));

//2.13 Verify the message “Success: You have modified your shopping cart!”

        WebElement elementMessage1 = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String actual1 = elementMessage1.getText();
        System.out.println(actual1);
        String expected1 = "Success: You have modified your shopping cart!";

        System.out.println(expected1);
        boolean message1 = actual1.contains(expected1.trim());
        Assert.assertTrue(message1);

//        2.14 Verify the Total Amount


        String expectedAmount= "$1,204.00";
        String actualAmount= getTextFromElement(By.xpath("//tbody//tr//td[6]"));
        Assert.assertEquals("Error Message",expectedAmount,actualAmount);



//        2.15 Click on “Checkout” button

clickOnElement(By.xpath("//a[@class='btn btn-primary']"));


//        2.16 Verify the text “Checkout”

        String expectedCheckout= "Checkout";
        String actualCheckout= getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals("Error Message",expectedCheckout,actualCheckout);



//        2.17 Verify the Text “New Customer”
Thread.sleep(1000);
        String expectedNewCustomer= "New Customer";
        String actualNewCustomer= getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals("Error Message",expectedNewCustomer,actualNewCustomer);

//        2.18 Click on “Guest Checkout” radio button
Thread.sleep(2000);
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));

//        2.19 Click on “Continue” tab


        clickOnElement(By.xpath("//input[@id='button-account']"));

//        2.20 Fill the mandatory fields
//
sendTextToElement(By.name("firstname"),"John");
        sendTextToElement(By.name("lastname"),"Smith");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"john@gmail.com");
        sendTextToElement(By.name("telephone"),"7689089567");
        sendTextToElement(By.name("address_1"),"Centeral London");
        sendTextToElement(By.name("city"),"London");
        sendTextToElement(By.name("postcode"),"HA9 2XY");
Thread.sleep(1000);
      WebElement dropDown1 =driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select select1 = new Select(dropDown1);
        select1.selectByVisibleText("United Kingdom");


        WebElement dropDown2 =driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select select2 = new Select(dropDown2);
        select2.selectByVisibleText("Greater London");


//        2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
//        2.22 Add Comments About your order into text area

sendTextToElement(By.xpath("//textarea[@name='comment']"),"Hello Payment Done");

//        2.23 Check the Terms & Conditions check box

        clickOnElement(By.xpath("//input[@name='agree']"));

//        2.24 Click on “Continue” button

        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

//        2.25 Verify the message “Warning: Payment method required!”




        WebElement elementMessage22 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String actual22 = elementMessage22.getText();
        System.out.println(actual22);
        String expected22 = "Warning: Payment method required!";

        System.out.println(expected22);
        boolean message22 = actual22.contains(expected22.trim());
        Assert.assertTrue(message22);


    }












    @After
    public void tearDown() {

        closeBrowser();
    }












}
