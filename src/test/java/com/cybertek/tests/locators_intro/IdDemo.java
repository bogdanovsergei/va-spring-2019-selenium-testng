package com.cybertek.tests.locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdDemo {

    public static void main(String[] args) {

    }

    public static void id2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        WebElement btn6 = driver.findElement(By.id("wooden_spoon"));
        Thread.sleep(1000);
        btn6.click();
    }

    public static void id1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cybertekschool.com/multiple_buttons");

        //driver - represents browser
        // findElement - commant to get certain element
        //By.id  - Which locator it should use

        WebElement btn6 = driver.findElement(By.id("dissapearing_button"));
        Thread.sleep(1000);
        btn6.click();
    }

}
