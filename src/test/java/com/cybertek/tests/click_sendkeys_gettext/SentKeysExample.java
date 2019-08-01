package com.cybertek.tests.click_sendkeys_gettext;

/*
TEST 001

open browser
go to http://practice.cybertekschool.com/forgot_password
click on Retrieve password
verify that url is the same

enter an email
 */
import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SentKeysExample {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        //creating element
        WebElement emailInput = driver.findElement(By.name("email"));

        //enters text on the webElement
        emailInput.sendKeys("randomemail@gmail.com");
        Thread.sleep(1000);

        //1 way (to click button):
        //clicking on btn
        WebElement retrivieBtn = driver.findElement(By.id("form_submit"));
        retrivieBtn.click();

        //checking are pages matching or not
        String expected = "http://practice.cybertekschool.com/forgot_password";
        String actual = driver.getCurrentUrl();
        VerificationUtils.verifyEquals(expected, actual);

    }
}
