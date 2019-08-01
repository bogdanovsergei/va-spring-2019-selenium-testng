package com.cybertek.tests.locators_intro;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TEST 003

open browser
go to http://practice.cybertekschool.com/forgot_password
enter any email
click on Retrieve password
verify new confirmation message 'Your e-mail's been sent!'


TEST 004

open browser
go to http://practice.cybertekschool.com/forgot_password
enter any email
verify that email text is displayed
 */
public class TextVerification {

    public static void main(String[] args) throws InterruptedException {
        test004();
    }

    public static void test003() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("randomemail@gmail.com");
        Thread.sleep(1000);

        WebElement retrivieBtn = driver.findElement(By.id("form_submit"));
        retrivieBtn.click();

        //give us not actual text // give a type I guess, or location
        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println("message = " + message);
        //give us actual text
        System.out.println("message = " + message.getText());

        String exp = "Your e-mail's been sent!";
        String act = message.getText();
        VerificationUtils.verifyEquals(exp, act);
    }

    public static void test004() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);

        WebElement emailInput = driver.findElement(By.name("email"));
        String exp = "randomemail@gmail.com";
        emailInput.sendKeys(exp);

        //getAtribute --> returns value of the given atribute of the element
        System.out.println(emailInput.getAttribute("name"));
        System.out.println(emailInput.getAttribute("type"));
        System.out.println(emailInput.getAttribute("value"));
        Thread.sleep(1000);

        //getAtribute(value) --> used to get text from input box etc

        String act = emailInput.getAttribute("value");
        VerificationUtils.verifyEquals(exp, act);

        //getAtribute("innerHTML")  --> if getAtribute(value) does not work, use this one
        System.out.println(emailInput.getAttribute("innerHTML"));

        //returns the HTML of given element
        System.out.println(emailInput.getAttribute("outerHTML"));

        //HOW TO DELETE TEXT FROM INPUT FIELD

        emailInput.clear();

    }
}
