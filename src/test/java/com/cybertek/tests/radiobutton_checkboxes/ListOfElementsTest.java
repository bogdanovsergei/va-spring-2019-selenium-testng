package com.cybertek.tests.radiobutton_checkboxes;

//Test case
//
//        go to http://practice.cybertekschool.com/radio_buttons
//        verify that none of the options under Select your favorite sport: are selected by default
//          select any radio button
//        verify that only that button is selected and others are not
//        select any other radio button
//        verify that only that other button is selected and others are not
//
//        NOTE: select different buttons every time

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        List<WebElement> buttons = driver.findElements(By.name("sport"));

        System.out.println("Number of buttons: " + buttons.size());

        // verify none selected
        // shortcut --> iter
        for (WebElement button : buttons) {
            VerificationUtils.verifySelected(button, false);
        }

        // select any radio button
        Random random = new Random();
        int number = random.nextInt(4);
        System.out.println("number = " + number);

        buttons.get(number).click();

        // verify that only that button is selected and others are not
        // itar = shortcut
        for (int i = 0; i < buttons.size(); i++) {
            if (i==number) {
                VerificationUtils.verifySelected(buttons.get(i), true);
            } else {
                VerificationUtils.verifySelected(buttons.get(i), false);
            }
        }

       // select any other radio button
        int number2;
        do {
            number2 = random.nextInt(4);
        } while (number2 == number);
        System.out.println("number2 = " + number2);

        buttons.get(number2).click();

        //verify that only that other button is selected and others are not
        for (int i = 0; i < buttons.size(); i++) {
            if (i==number2) {
                VerificationUtils.verifySelected(buttons.get(i), true);
            } else {
                VerificationUtils.verifySelected(buttons.get(i), false);
            }
        }

        System.out.println(buttons.get(number2).getText());


    }
}
