package desktops;

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

public class DesktopsTest extends Utility {

    static String month = "November 2022";
    static String date = "30";


    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

//1.Test name verifyProductArrangeInAlphaBaticalOrder()
//1.1 Mouse hover on Desktops Tab.and click




@Test
public void verifyProductArrangeInAlphaBaticalOrder(){
    //1.1 Mouse hover on Desktops Tab.and click
    mouseHoverClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
//mouseHoverClick(By.xpath("//a[normalize-space()='Desktops']"));

    //1.2 Click on “Show All Desktops”
    mouseHoverClick(By.xpath("//a[normalize-space()='Show AllDesktops']"));

//1.3 Select Sort By position "Name: Z to A"

    WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
    Select select = new Select(dropDown);
    select.selectByVisibleText("Name (Z - A)");
// 1.4 Verify the Product will arrange in Descending order.

    ArrayList<String> actualList = new ArrayList<>();

    List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='caption']//h4"));
    System.out.println("listOfElements=" + listOfElements);
    for (WebElement element : listOfElements) {
        actualList.add(element.getText());
        System.out.println(element.getText());
    }

    System.out.println("actual list = " + actualList);

    ArrayList<String> expectedList = new ArrayList<>();
    for (WebElement element : listOfElements) {
        expectedList.add(element.getText());
        System.out.println("expected list = " + element.getText());
    }

    System.out.println("expected list = " + expectedList);

   // Thread.sleep(3000);
    // z -a
    Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
    System.out.println("expected sort = " + expectedList);
    Collections.reverse(expectedList);

    System.out.println("expected reverse = " + expectedList);
    Assert.assertEquals("Not matching", expectedList, actualList);
}



//2. Test name verifyProductAddedToShoppingCartSuccessFully()

@Test
public void verifyProductAddedToShoppingCartSuccessFully(){

        //2.1 Mouse hover on Desktops Tab. and click
    mouseHoverClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
   // 2.2 Click on “Show All Desktops”
    clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
//2.3 Select Sort By position "Name: A to Z"
    WebElement dropDown =driver.findElement(By.xpath("//select[@id='input-sort']"));
    Select select = new Select(dropDown);
    select.selectByVisibleText("Name (A - Z)");
//2.4 Select product “HP LP3065”

 clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
//2.5 Verify the Text "HP LP3065"
    String expectedName= "HP LP3065";
    String actualName=getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
    Assert.assertEquals("Error Message displayed",expectedName,actualName);

//2.6 Select Delivery Date "2022-11-30"
    clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); ////input[@id='input-option225']

    while (true) {
        WebElement element = driver.findElement(By.cssSelector(".picker-switch"));
        String text = element.getText().trim();

        if (text.equals(month)) {
            break;
        } else {
            driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")).click();
        }
    }

    List<WebElement> dateList = driver.findElements(By.xpath("//tbody//tr//td[@class='day']"));
    for (WebElement element : dateList) {
        if (element.getText().trim().equals(date)) {
            System.out.println("my day=" + element.getText().trim());
            element.click();
            break;
        }
    }



   // 2.7.Enter Qty "1” using Select class.

 sendTextToElement(By.xpath("//input[@id='input-quantity']"),"");
//2.8 Click on “Add to Cart” button

    clickOnElement(By.xpath("//button[@id='button-cart']"));
   // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    WebElement elementMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
    String actual = elementMessage.getText();
    System.out.println(actual);
    String expected = "Success: You have added HP LP3065 to your shopping cart!";

    System.out.println(expected);
    boolean message = actual.contains(expected.trim());
    Assert.assertTrue(message);
   // Thread.sleep(2000);



   // 2.10 Click on link “shopping cart” display into success message

    clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

//2.11 Verify the text "Shopping Cart"



    String expectedCartMsg= "Shopping Cart  (1.00kg)";
  String actualCartMsg=getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
    Assert.assertEquals("Error Message displayed",expectedCartMsg,actualCartMsg);
//2.12 Verify the Product name "HP LP3065"

    String expectedProductName= "HP LP3065";
    String actualProductName=getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
    Assert.assertEquals("Error Message displayed",expectedProductName,actualProductName);
//2.13 Verify the Delivery Date "2022-11-30"

    String expectedDeliveryDate= "Delivery Date:2022-11-30";
    String actualDeliveryDate=getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
    Assert.assertEquals("Error Message displayed",expectedDeliveryDate,actualDeliveryDate);
//

    //2.14 Verify the Model "Product21"

    String expectedModel= "Product 21";
    String actualModel=getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
    Assert.assertEquals("Error Message displayed",expectedModel,actualModel);
//2.15 Verify the Total "£74.73"
    String expectedTotal= "$122.00";
    String actualTotal=getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"));
    Assert.assertEquals("Error Message displayed",expectedTotal,actualTotal);





}


    @After
    public void tearDown() {

        closeBrowser();
    }









}
