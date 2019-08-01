package com.cybertek.tests.review1;

import com.cybertek.utilities.VerificationUtils;
import com.cybertek.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateButtonTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //Verify for store manager
    @Test
    public void storeManagerTest() throws InterruptedException {
        VytrackUtils.login(driver, "storemanager51", "UserUser123");

        //click on activities ==> Calls
        VytrackUtils.selectMenuOption(driver, "Activities", "Calls");
        String css = "a[title='Log call']";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.cssSelector(css)));

        //click on Calendar Events
        VytrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");
        css = "a[title='Create Calendar event']";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.cssSelector(css)));
    }

    //Verify for sales manager
    @Test
    public void salesManagerTest() throws InterruptedException {
        VytrackUtils.login(driver, "salesmanager123", "UserUser123");
        VytrackUtils.selectMenuOption(driver, "Activities", "Calls");
        String css = "a[title='Log call']";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.cssSelector(css)));

        VytrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");
        css = "a[title='Create Calendar event']";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.cssSelector(css)));


    }

}
