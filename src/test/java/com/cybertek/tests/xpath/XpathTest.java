package com.cybertek.tests.xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XpathTest {

    @Test
    public void absoluteXpath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/signup_confirmation");
       // /html/body/div/div/div/div/a

        System.out.println("printing the first link");
        System.out.println(
                driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());

        System.out.println("printing the second link");
        System.out.println(
                driver.findElement(By.xpath("/html/body/div/div/div/div/a")).getText());

    }

    @Test
    public void relativeXpathUsingParentChild() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/signup_confirmation");

        System.out.println("printing the first link");
        System.out.println(
                driver.findElement(By.xpath("//body/nav/ul/li/a")).getText());

        System.out.println("printing the first link again");
        System.out.println(
                driver.findElement(By.xpath("//body/nav//a")).getText());
    }

    @Test
    public void relativeXpathUsingAttributeValue() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.xpath("//button[@id='disappearing_button']")).click();

        //ANY TAG
        driver.findElement(By.xpath("//*[@id='disappearing_button']")).click();

        //ANY ATTRIBUTE
        driver.findElement(By.xpath("//button[@*='disappearing_button']")).click();

        //CONTAINS
        //tag[contains(@attr, 'value')]
        driver.findElement(By.xpath("//button[contains(@id, 'button_')]")).getText();

    }

    @Test
    public void relativeXPathUsingText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //BY EXACT TEXT
        //tag[.='text']
        System.out.println(driver.findElement(By.xpath("//button[.='Button 3']")).getText());

        //USING PARTIAL text
        System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'click')]")).getText());

    }

    @Test
    public void relativeXpathByIndex() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //NTH CHILD
        System.out.println(driver.findElement(By.xpath("//button[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//button[3]")).getText());
    }

}
