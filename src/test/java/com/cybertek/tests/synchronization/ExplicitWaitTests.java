package com.cybertek.tests.synchronization;

import com.cybertek.utilities.VytrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTests {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void waitForVisible() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        //driver.findElement(By.id("username")).sendKeys("tomsmith");

        //ECPLICIT WAIT wait for certain actions
                //hidden elements to be visible or not
        /*WebDriverWait(driver,seconds)  --> class which enable explicitly wait for certain action
                        driver
                        certain amount of time
                        certain action
                        on certain element
             until() -- method starts waiting. It takes ExpectedConditions as a parameter
             ExpectedConditions --> what do we want to wait

         */

        //create webdriver wait object and pass driver and wait duration
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //start waiting for certain element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("tomsmith");

    }

    @Test

    public void waitForClickable() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.cssSelector("#input-example>button")).click();

        WebElement input = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver, 3);
        // wait.until(ExpectedConditions.elementToBeClickable(input));

        wait.               // --> this is wait object
                until(      // --> waiting starts when we call until method
                        ExpectedConditions.elementToBeClickable(    // --> what are we waiting for? element to be clickable
                                input));    //--> which element

        input.sendKeys("hello world");
    }

    @Test
    public void explicitNotHelpingUsingThreadSleepTest() {
        driver.get("http://qa3.vytrack.com");
        VytrackUtils.login(driver, "storemanager51", "UserUser123");

        // //*[.='Loaiding...'] --> locator for the loading button
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[.='Loading...']")));

        //AAAAAAAAAAAA DOESNT WORK
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), 'Sales')]";
        driver.findElement(By.xpath(tabXpath)).click();

        //driver.findElement(By.linkText("My Calendar")).click();
    }
}
