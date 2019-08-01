package com.cybertek.tests.click_sendkeys_gettext;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickExample {
    public static void main(String[] args) throws InterruptedException {

        //WebDriverManager dependency for aitimationg the driver managment in selenium
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        String expectedUrl = "http://practice.cybertekschool.com/forgot_password";
        driver.get(expectedUrl);

        //method findElement used to get certain element
        WebElement retrieveButton    = driver.findElement(By.id("form_submit"));
        Thread.sleep(2000);
        retrieveButton.click();

        //verify that we are on the same page
        String url = driver.getCurrentUrl();
        VerificationUtils.verifyEquals(expectedUrl, url);



    }
}
