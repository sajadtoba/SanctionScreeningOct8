package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver =null;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
//        driver= new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.get("https://www.walmart.com/");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
//        System.out.println("Sajad wants to get the Title of the Page:  "+driver.getTitle());
//        System.out.println("Sumaira wants to get the class:     "+driver.getClass());
//        System.out.println("Bladmir wants to get the current url of the page:   "+driver.getCurrentUrl());

    }
//    @Test
//    public void testGettheBasicInfo(){
//        System.out.println("Sajad wants to get the Title of the Page:  "+driver.getTitle());
//        System.out.println("Sumaira wants to get the class:     "+driver.getClass());
//        System.out.println("Bladmir wants to get the current url of the page:   "+driver.getCurrentUrl());
//
//    }


    @AfterMethod
    public void clearUp(){
        driver.close();
    }
}
