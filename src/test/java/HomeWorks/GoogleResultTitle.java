package HomeWorks;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class GoogleResultTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "Selenium");

        for (int i=0; i<searchStrs.size(); i++) {
            driver.findElement(By.name("q")).sendKeys(searchStrs.get(i) + Keys.ENTER);
            String url = driver.findElement(By.className("iUh30")).getText();
            //System.out.println("url = " + url);
            driver.findElement(By.className("LC20lb")).click();
            VerificationUtils.verifyEquals(driver.getCurrentUrl(), url);
            driver.navigate().back();
            driver.navigate().back();
        }
        driver.quit();
    }
}

