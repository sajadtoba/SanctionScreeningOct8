package testRunnerAllClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    public WebDriver driver;

    @BeforeMethod
    public void setUpAmazon() {
        System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
        driver = new ChromeDriver();


//        System.setProperty("webdriver.gecko.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get("https://www.walmart.com/");
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("books best sellers");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
        //driver.findElement(By.cssSelector(".nav-input")).click();
        System.out.println("Sajad wants to get the Title   :" + driver.getTitle());
    }

    // if there are only searching 2 items then it works fine you can search even without using the clear method
    // But if you want to search more than 2 items then you must need to use the clear method, otherwise you won't able to search the 3rd item

    @Test
    public void test2UsingEniumKey(){
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("books best sellers", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("computer", Keys.ENTER);
    }




// public void clearItem(){
//        searchBar.clear();
//    }





    @AfterMethod
    public void cleanUp() {
        //driver.close();
    }
}


//public class AmazonHome extends CommonAPI {
//    @FindBy(id="twotabsearchtextbox")
//    public WebElement searchBar;
//    @FindBy(xpath = "//input[@class='nav-input' and @type='submit']")
//    private WebElement searchButton;
//     @FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/a[2]/div[1]/span[1]")
//    private WebElement signInBtn;
//
//
//
//
//     //******************* Below is creating the methods and calling the stored variables inside the Webelements
//    public void searchItems(String item){
//        searchBar.sendKeys(item, Keys.ENTER);
//    }
//    //******************* The above method is search Items  ********************************************
//
//    public void clearItem(){
//        searchBar.clear();
//    }
//
//    //************** to see the items one by one on the search bar instead of seeing all of the items in one time