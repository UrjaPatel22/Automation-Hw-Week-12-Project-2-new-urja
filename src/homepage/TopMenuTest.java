package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {


    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }



// 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
            public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

//        1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
 //       mouseHoverClick(By.linkText("Desktops"));
//        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String menu = "Show AllDesktops";
        selectMenu(menu);

//        1.3 Verify the text ‘Desktops
        String expectedMessage1= "Desktops";
        String actualMessage1=getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        Assert.assertEquals("Error Message displayed",expectedMessage1,actualMessage1);
            }


//2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()





    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click

        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”

        String menu = "Show AllLaptops & Notebooks";
        selectMenu(menu);

        // 2.3 Verify the text ‘Laptops & Notebooks’
        String expectedMessage1= "Laptops & Notebooks";
        String actualMessage1=getTextFromElement(By.cssSelector("div[id='content'] h2"));
        Assert.assertEquals("Error Message displayed",expectedMessage1,actualMessage1);



    }

//    3. verifyUserShouldNavigateToComponentsPageSuccessfully()


//

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.linkText("Components"));
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        String menu = "Show AllComponents";
        selectMenu(menu);
        // 3.3 Verify the text ‘Components’
        String expectedMessage1= "Components";
        String actualMessage1=getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        Assert.assertEquals("Error Message displayed",expectedMessage1,actualMessage1);

    }





    @After
    public void tearDown() {

        closeBrowser();
    }
}
