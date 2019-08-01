package com.cybertek.tests.review1;

import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTimeStuff {

    public static void main(String[] args) {
        WebDriver driver;
        //gives you date and time
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);
        //use to format the display of date, time

        String date = localDateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
        System.out.println(date);
        String time = localDateTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        System.out.println(time);

        //String actualDate = driver.findElement()
    }
}
