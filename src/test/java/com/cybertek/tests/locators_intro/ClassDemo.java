package com.cybertek.tests.locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassDemo {
    public static void main(String[] args) {
        class2();
    }

    public static void class2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //try to cick on element which has am space separated classes
        System.out.println(driver.findElement(By.className("btn btn-primary")).getText());
    }

    public static void class1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");

        System.out.println(driver.findElement(By.className("subheader")).getText());

        //click on the home link
        driver.findElement(By.className("nav-link")).click();

    }
}
