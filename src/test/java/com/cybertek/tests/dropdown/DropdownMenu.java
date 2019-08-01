package com.cybertek.tests.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement selectElement = driver.findElement(By.id("dropdown"));
        Select dropdownList = new Select(selectElement);

        //READ THE SELECTED OPTIONS
        WebElement selectOption = dropdownList.getFirstSelectedOption();    //--> return the selected option
        System.out.println(selectOption.getText());

        //GET ALL AVAILABLE OPTIONS
        List<WebElement> allOptions = dropdownList.getOptions();    // --> returns all available options as a List
        System.out.println("Number of options: " + allOptions.size());
        System.out.println();

        for (WebElement option: allOptions) {
          //  System.out.println(option.getText());
        }

        Thread.sleep(1000);
        //HOW TO SELECT USING VISIBLE TEXT
        dropdownList.selectByVisibleText("Option 1");       //--> select by visible text
        selectOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectOption.getText());

        Thread.sleep(500);
        dropdownList.selectByVisibleText("Option 2");
        selectOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectOption.getText());

        //HOW TO SELECT USING INDEX
        Thread.sleep(500);
        dropdownList.selectByIndex(1);                       //--> select by index
        selectOption = dropdownList.getFirstSelectedOption();
        System.out.println(selectOption.getText());

        //HOW TO SELECT USING THE VALUE ATTRIBUTE
        dropdownList.selectByValue("2");                        // --> select by value

    }
}
