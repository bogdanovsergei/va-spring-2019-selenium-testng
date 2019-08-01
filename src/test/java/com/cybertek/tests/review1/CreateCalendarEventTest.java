package com.cybertek.tests.review1;

import com.cybertek.utilities.VerificationUtils;
import com.cybertek.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCalendarEventTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpTest(){
        // Login as store manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void saveAndCancelOptionsTest () throws InterruptedException {
        VytrackUtils.login(driver, "salesmanager123", "UserUser123");
        VytrackUtils.selectMenuOption(driver, "Activities", "Calendar Events");
        driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        Thread.sleep(2000);
        String cancelCss = "a[title='Cancel']";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.cssSelector(cancelCss)));

        // verify that Save and CLose button is displayed
        String saveAndCloseBtn = "(//div[contains(@class, 'btn-group pull-right')]//button)[1]";
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.xpath(saveAndCloseBtn)));

        driver.findElement(By.className("caret")).click();
        Thread.sleep(2000);

        String saveCloseOption = "(//div[contains(@class, 'btn-group pull-right')]//button)[2]";
        String saveNewOption = "(//div[contains(@class, 'btn-group pull-right')]//button)[3]";
        String saveOption = "(//div[contains(@class, 'btn-group pull-right')]//button)[4]";

        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.xpath(saveCloseOption)));
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.xpath(saveNewOption)));
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.xpath(saveOption)));

        driver.findElement(By.className("caret")).click();
        Thread.sleep(2000);
        Assert.assertFalse(VerificationUtils.isElementDisplayed(driver, By.xpath(saveCloseOption)));

    }

    @Test
    public void defaultOptions () {
        String expected = driver.findElement(By.cssSelector("#user-menu>a")).getText().trim();
        String actual = driver.findElement(By.className("select2-chosen")).getText().trim();
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }
}