package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
/**
 * Complete the implementation of methods.
 * All of the methods are about the first web table
 * from the http://practice.cybertekschool.com/tables
 * Run the test following any method to test it
 */
public class TableOneTest extends TestBase {
    @BeforeMethod
    public void setUpMethodSubClass() {
        driver.get("http://practice.cybertekschool.com/tables");
    }

    /**
     * method that returns the number of rows including headers in table 1
     */

    public int getRowCount() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        return allRows.size();
    }

    @Test
    public void getRowCountTest() {
        assertEquals(getRowCount(), 5, "Number of rows did not match");
    }

    /**
     * method that returns the number of columns in table 1
     */
    public int getColCount() {
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        return cols.size();
    }

    @Test
    public void getColCountTest() {
        assertEquals(getColCount(), 6, "Number of columns did not match");
    }

    /**
     * method that returns the size of the table 1
     *
     * @return
     */
    public int[] getTableSize() {
        int[] size = new int[2];
        size[0] = getRowCount();
        size[1] = getColCount();
        return size;
    }

    @Test
    public void getTableSizeTest() {
        int[] expectedSize = new int[]{5, 6};
        assertEquals(getTableSize(), expectedSize, "Table size did not match");
    }

    /**
     * method that returns all headers in table 1
     *
     * @return
     */
    public List<WebElement> getHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        return headers;
    }

    @Test
    public void getHeadersTest() {
        List<String> expectedHeaders = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<String> actualHeaders = BrowserUtils.getElementsText(getHeaders());
        assertEquals(actualHeaders, expectedHeaders, "Headers did not match");
    }

    /**
     * method that returns all cells under given column in table 1
     *
     * @param colName
     * @return
     */
    public List<WebElement> getCellsInColumn(String colName) {
        List<WebElement> cellsInCol = new ArrayList<>();
        switch (colName) {
            case "Last Name":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
                break;
            case "First Name":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
                break;
            case "Email":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
                break;
            case "Due":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
                break;
            case "Web Site":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[5]"));
                break;
            case "Action":
                cellsInCol = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[6]"));
                break;
        }
        return cellsInCol;
    }
    @Test
    public void getCellsInColumnTest() {
        List<String> expectedLastNames = Arrays.asList("Smith", "Bach", "Doe", "Conway");
        List<String> actualLastNames = BrowserUtils.getElementsText(getCellsInColumn("Last Name"));
        assertEquals(actualLastNames, expectedLastNames, "First names did not match");
        List<String> expectedFirstNames = Arrays.asList("John", "Frank", "Jason", "Tim");
        List<String> actualFirstNames = BrowserUtils.getElementsText(getCellsInColumn("First Name"));
        assertEquals(actualFirstNames, expectedFirstNames, "First names did not match");
    }

    @Test
    public void itirateTable(){

        for (int i = 1; i < getRowCount(); i++) {
            for (int j = 1; j <= getColCount(); j++) {
                String xpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(driver.findElement(By.xpath(xpath)).getText());

            }

        }
    }
}