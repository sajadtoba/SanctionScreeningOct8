package testRunnerAmazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    public WebDriver driver;
    @BeforeMethod
public void setUpAmazon(){
//    System.setProperty("webdriver.chrome.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
//    driver = new ChromeDriver();


System.setProperty("webdriver.gecko.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");

driver= new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    //driver.get("https://www.walmart.com/");
    driver.get("https://www.amazon.com/");
}

@Test
public void test1(){
    //driver.getTitle();
    System.out.println("Sajad wants to get the Title   :"+driver.getTitle());
}
@AfterMethod
public void cleanUp(){
    driver.close();
}
}
