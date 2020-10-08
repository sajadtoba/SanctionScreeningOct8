package home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Amazon {
    public  static WebDriver driver = null; // below the method is static
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.get("https://www.walmart.com/");
        driver.get("https://www.amazon.com/");

    }

}
