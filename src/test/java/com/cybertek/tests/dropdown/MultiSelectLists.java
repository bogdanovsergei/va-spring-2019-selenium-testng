package com.cybertek.tests.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectLists {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select list = new Select(driver.findElement(By.name("Languages")));

        Thread.sleep(1000);

        //we can select multiple options
        list.selectByVisibleText("Java");
        list.selectByVisibleText("Python");
        list.selectByVisibleText("C");

        //list.getAllSelectedOptions();       // returns all selected options

        for (WebElement selectedOption: list.getAllSelectedOptions()) {
            System.out.println(selectedOption.getText());
        }

        Thread.sleep(1000);
        list.deselectByVisibleText("Java");


    }
}
