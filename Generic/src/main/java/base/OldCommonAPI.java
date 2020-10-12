package base;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class OldCommonAPI {
    public WebDriver driver = null;

    @BeforeMethod
    @Parameters({"url"})
    public void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void clearUp() {
        driver.close();
    }

    //************************************               *******************************************************************************************

    // This clickOnElement() method we can use for any module by using any one of the locators.
    public void clickOnElement(String locator) { // Exception opens  but try block we open and enter the driver.find() and then close
        try {
            driver.findElement(By.cssSelector(locator));
        } catch (Exception ex) { // All of the Exception we open create variable ex and then close at the end of the method
            try {
                driver.findElement(By.xpath(locator));
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator));
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.className(locator));
                    } catch (Exception ex3) {
                        driver.findElement(By.name(locator));
                    }
                }
            }
        }
    }
    //************************************               *******************************************************************************************

    // void 2 parameterized(locator), 2nd value) method
    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception e) { // Open the catch block but we will close the catch code block at the end // 1st catch code block
            try {
                driver.findElement((By.xpath(locator))).sendKeys(value);
            } catch (Exception e1) {   // 2nd catch code block opened
                try {
                    driver.findElement(By.className(locator)).sendKeys(value);
                } catch (Exception e2) { // 3rd catch code block open curly braces
                    try {
                        driver.findElement(By.id(locator)).sendKeys(value);
                    } catch (Exception e3) { //4th catch code block and we do not need any more try code block then last option we can put inside the catch code block
                        driver.findElement(By.name(locator)).sendKeys(value);
                    } // belong to the 4th catch code block
                } // belong to 3rd catch code block
            } // belong to 2nd catch code block
        } // this is belong to the first catch block
    } // belong to the main method

    //************************************               *******************************************************************************************
    // We need void() with 2 signatures and we are going to use the enum java Keys
    public void typeSendAndClickOnElement(String locator, String value) { // method code block starts
        // We can use try code block to recover the scenario
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception e) { // Open 1st catch code block and it will end at the end of the () method
            try {
                driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception e1) { // open 2nd catch code block and created the 2nd variable e1
                try {
                    driver.findElement(By.className(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception e2) { // Belong to 3rd catch code block and creating the 3rd variable e2
                    try {
                        driver.findElement(By.xpath(locator)).sendKeys(value);
                    } catch (Exception e3) {  // last now we do not need try block anymore. we can put the last option inside for this catch code block
                        driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                    }// Belong to last catch code bloc
                } // Belong to 3rd catch code block
            }// Belong to 2nd catch code block
        } // Belong to 1st catch code block
    } // method code block closed

    //************************************               *******************************************************************************************

    //***************  type inside the Search window, then send keys or Click method by using the CssSelector
    public void typeOnElementBycss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void clickOnElementBycssSelector(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }


    //***************  type inside the Search window, then send keys or Click method by using the CssSelector
    public void typeAndClickOnElementBycss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    //***************  type inside the Search window, then send keys or Click method by using the xpath
    public void typeOnElementByxPath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void clickOnElementByxPth(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    //***************  type inside the Search window, then send keys or Click method by using the xPath
    public void typeAndClickOnElementByxPath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    //***************  type inside the Search window, then send keys or Click method by using by Id
    public void typeOnElementById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public void clickOnElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    //***************  type inside the Search window, then send keys or Click method by using by Id
    public void typeAndClickOnElementById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
    }

    //***************  type inside the Search window, then send keys or Click method by using the ClassName
    public void typeOnElementByClassName(String locator, String value) {
        driver.findElement(By.className(locator)).sendKeys(value);
    }

    public void clickOnElementByClassName(String locator) {
        driver.findElement(By.className(locator)).click();
    }

    //***************  type inside the Search window, then send keys or Click method by using the ClassName
    public void typeAndClickOnElementByClassName(String locator, String value) {
        driver.findElement(By.className(locator)).sendKeys(value, Keys.ENTER);
    }
}










