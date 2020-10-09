package testRunnerAllClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWalmart {
    WebDriver driver;


    @BeforeMethod
    public void setUpWalmart(){
        System.setProperty("webdriver.chrome.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://www.walmart.com/");
    }

    @Test
    public void searchItems() throws InterruptedException {
      driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/input[2]")).sendKeys("books",Keys.ENTER);
     driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
    Thread.sleep(400);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("bicycle for kids",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/input[2]")).sendKeys("computers",Keys.ENTER);
        //driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("women shoes",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("bicycle for men",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        Thread.sleep(200);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/input[2]")).sendKeys("iphone",Keys.ENTER);
        //driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("iphone",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("bicycle tube",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[3]/div[2]/div[1]/form[1]/input[2]")).sendKeys("printer ink",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        Thread.sleep(300);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("table lamp",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("computers",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
        driver.findElement(By.xpath("//input[@id='global-search-input']")).sendKeys("aircondition",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='global-search-input']")).clear();
    }
    @AfterMethod
    public void clearnUp(){
        driver.close();
    }
}
