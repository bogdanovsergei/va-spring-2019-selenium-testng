package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackTitleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa3.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user31");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.name("_submit")).click();
        String nameMenu = driver.findElement(By.className("dropdown-toggle")).getText();
        Thread.sleep(1000);
        driver.findElement(By.className("dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("mobile-hide")).click();

        Thread.sleep(1000);
        String nameTitle = driver.getTitle();

        if (nameTitle.startsWith(nameMenu)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("name in Menu: " + nameMenu);
            System.out.println("name in Title: " + nameTitle);
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
