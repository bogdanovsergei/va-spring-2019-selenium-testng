package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearchTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon" + Keys.ENTER);
        String result1 = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println("result = " + result1);
        driver.findElement(By.linkText("All")).click();
        String result2 = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println("result2 = " + result2);

        result1 = result1.substring(0, result1.length()-8).replace(",", "");
        result2 = result2.substring(0, result2.length()-8).replace(",", "");

        //System.out.println(Integer.parseInt(result2));
        //System.out.println(Integer.parseInt(result1));

        if (Integer.parseInt(result2) > Integer.parseInt(result1)) {
            System.out.println("Comparison results test: PASS");
        } else {
            System.out.println("Comparison results test: FAIL");
        }

        driver.navigate().back();
        if (driver.findElement(By.name("_nkw")).getAttribute("value").equals("wooden spoon")) {
            System.out.println("1 check: PASS");
        } else {
            System.out.println("1 check: FAIL");
            System.out.println("Expected: " + "wooden spoon");
            System.out.println("Actual: " + driver.findElement(By.name("_nkw")).getAttribute("value"));
        }

        driver.navigate().back();
        if (driver.findElement(By.name("_nkw")).getAttribute("value").equals("")) {
            System.out.println("2 check: PASS");
        } else {
            System.out.println("2 check: FAIL");
        }


    }
}
