package com.cybertek.tests.radiobutton_checkboxes;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //verify checkbox
        WebElement one = driver.findElement((By.xpath("//input[1]")));
        WebElement two = driver.findElement((By.xpath("//input[2]")));

        System.out.println("one is selected: " + one.isSelected());
        System.out.println("two is selected: " + two.isSelected());

        System.out.println("Verifying default");
        VerificationUtils.verifySelected(one, false);
        VerificationUtils.verifySelected(two, true);

        System.out.println("Clicking on one");
        one.click();
        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, true);

        System.out.println("Clicking on two");
        two.click();
        VerificationUtils.verifySelected(one, true);
        VerificationUtils.verifySelected(two, false);

        //how to see if the element is selected using its attributes
        System.out.println(one.getAttribute("type"));
        System.out.println(one.getAttribute("checked"));
        System.out.println(two.getAttribute("checked"));


    }
}
