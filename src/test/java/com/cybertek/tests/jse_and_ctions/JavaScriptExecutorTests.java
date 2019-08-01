package com.cybertek.tests.jse_and_ctions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    /*javascript --> programming/scripting language. works on browser
    selenium is not capable of doing some operations on thebrowser.
    When selenium falls short, we use java scriot to do those operations
    */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void jse1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);

        //JavascriptExecutor object is created (casting)
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //it takes string parameter and pass ...
        jse.executeScript("alert('Welcome to cybertek!');");
    }

    @Test
    public void scroll () throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll down on page
            Thread.sleep(1000);
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("http://practice.cybertekschool.com/large");

        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(1000);
        //scroll until link is found
        jse.executeScript("arguments[0].scrollIntoView()", link);
        Thread.sleep(1000);
        //click on this link
        jse.executeScript("arguments[0].click()", link);

    }

    @Test
    public void type() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        Thread.sleep(1000);

        WebElement input = driver.findElement(By.cssSelector("#input-example>input"));

        String string = "blah blah blah";
        jse.executeScript("arguments[0].setAttribute('value', '"+string+"')", input);
    }


}
