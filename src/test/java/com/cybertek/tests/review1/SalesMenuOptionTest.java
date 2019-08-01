package com.cybertek.tests.review1;

import com.cybertek.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesMenuOptionTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }


    @Test
    public void storeManagerTest() throws InterruptedException {

        VytrackUtils.login(driver, "storemanager71", "UserUser123");

        //GETTING TEXT SALES USING DIFFERENT WAYS:

        //xpath contains text
        //a/span[contains(text(), 'Sales')]
        System.out.println(driver.findElement(By.xpath("//a/span[contains(text(), 'Sales')]")).getText());

        //tag[@attr='value' and @attr='value']
        //span[@class='title title-level-1' and contains(text(), 'Sales')]
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(), 'Sales')]")).isDisplayed());

    }

    @Test
    public void driverTest() throws InterruptedException {
        VytrackUtils.login(driver, "user32", "UserUser123");
        try {
            Assert.assertFalse(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(), 'Sales')]")).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }


}
