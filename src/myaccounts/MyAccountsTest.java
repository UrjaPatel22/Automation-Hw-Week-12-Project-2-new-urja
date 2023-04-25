package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

//    1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
//1.2 This method should click on the options whatever name is passed as parameter.
    public void selectMyAccountOptions(String option){
        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
        try {
            for (WebElement option1 : registerList) {
                System.out.println(option1.getText());
                if (option1.getText().equals(option)) {
                    option1.click();
                    //break;
                }
            }

        } catch (StaleElementReferenceException e) {
            registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()throws InterruptedException{

        Thread.sleep(2000);
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //1.2 1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String expectedRegister="Register Account";

        String actualRegister=getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals("Error Message displayed",expectedRegister,actualRegister);

    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully()throws InterruptedException{
        Thread.sleep(2000);
        //2.1  Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        String expectedLogin="Returning Customer";
        String actualLogin=getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        Assert.assertEquals("Error Message displayed",expectedLogin,actualLogin);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully()throws InterruptedException{

        Thread.sleep(2000);
        //3.1  Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        //3.3  Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"John");
        //3.4  Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Smith");
        //3.5  Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"john9978@gmail.com");
        //3.6  Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"123456789");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"abc123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"abc123");
        //3.9 Select Subscribe Yes radio button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        // 3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // 3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        // 3.12 Verify the message “Your Account Has Been Created!”
        Thread.sleep(2000);

        String expectedRegisterMessage="Your Account Has Been Created!";
        String actualRegisterMessage=getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals("Error Message displayed",expectedRegisterMessage,actualRegisterMessage);


        // 3.13 Click on Continue button

        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter Logout
        selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”

        String expectedLogout="Account Logout";
        String actualLogout=getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Error Message displayed",expectedLogout,actualLogout);


        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully()throws InterruptedException{
        Thread.sleep(2000);
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter Login
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"john9978@gmail.com");
        //4.4  Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"abc123");
        //4.6 Click on Login button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”


        String expectedAccount="My Account";
        String actualAccount=getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals("Error Message displayed",expectedAccount,actualAccount);


        //4.8  Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //4.9  Call the method “selectMyAccountOptions” method and pass the parameter “Logout
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”



        String expectedLogout="Account Logout";
        String actualLogout=getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals("Error Message displayed",expectedLogout,actualLogout);



        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }



    @After
    public void tearDown() {

        closeBrowser();
    }


}
