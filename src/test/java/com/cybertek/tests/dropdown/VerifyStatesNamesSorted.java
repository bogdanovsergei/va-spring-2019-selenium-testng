package com.cybertek.tests.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VerifyStatesNamesSorted {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select states = new Select(driver.findElement(By.id("state")));

        List<WebElement> options = states.getOptions();
        System.out.println(options.size());

        //iterate through the options and compare one option to the next one

        for (int i=0; i<options.size()-1; i++) {
            String current = options.get(i).getText();
            String next = options.get(i+1).getText();
            System.out.println("Comparing: " + current + " " + next);
            if (current.compareTo(next) < 0) {              // if one >two ==> positive
                System.out.println("PASS");                 // if two > one ==> -1
            } else {                                        // two==one ==> 0
                System.out.println("FAIL");
            }

        }

    }
}
