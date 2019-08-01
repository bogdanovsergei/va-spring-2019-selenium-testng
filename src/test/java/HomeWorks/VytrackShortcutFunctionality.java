package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackShortcutFunctionality {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager131");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(2000);
        driver.findElement(By.className("fa-share-square")).click();
        driver.findElement(By.className("extra-small")).click();



    }
}
