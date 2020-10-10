package base;

import org.openqa.selenium.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sqlite.util.StringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
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
    public void typeOnElement(String locator, String value){
        try{
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        }catch (Exception e){ // Open the catch block but we will close the catch code block at the end // 1st catch code block
            try{
                driver.findElement((By.xpath(locator))).sendKeys(value);
            }catch (Exception e1) {   // 2nd catch code block opened
                try{
                    driver.findElement(By.className(locator)).sendKeys(value);
                } catch (Exception e2) { // 3rd catch code block open curly braces
                    try{
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
    public void typeSendAndClickOnElement(String locator, String value){ // method code block starts
        // We can use try code block to recover the scenario
        try{
            driver.findElement(By.cssSelector(locator)).sendKeys(value,Keys.ENTER);
        } catch (Exception e){ // Open 1st catch code block and it will end at the end of the () method
            try {
                driver.findElement(By.id(locator)).sendKeys(value,Keys.ENTER);
            } catch (Exception e1) { // open 2nd catch code block and created the 2nd variable e1
                try{
                    driver.findElement(By.className(locator)).sendKeys(value,Keys.ENTER);
                } catch (Exception e2) { // Belong to 3rd catch code block and creating the 3rd variable e2
                    try {
                        driver.findElement(By.xpath(locator)).sendKeys(value);
                    } catch (Exception e3) {  // last now we do not need try block anymore. we can put the last option inside for this catch code block
                        driver.findElement(By.name(locator)).sendKeys(value,Keys.ENTER);
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


//==================================================--------------------------------
// ********************* Mr. Mafi Common API starts.









    //ExtentReport
    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    // create the reference variable for the interface (Webdriver) and initialize with the null value that
    // we can use the rf (driver) for other methods also
    //public static WebDriver driver = null;
    // We need to make a static because if we like to use inside of the static method
    // then it must me static because non-static data cannot be called inside the static method    //Browser SetUp

    // Browser SetUp *********************************** Browser set up ***************************************************************
    //public static WebDriver driver = null;
    public String browserstack_username= "sajjad65";
    public String browserstack_accesskey = "WKrsTRMyZ4FFSoNPz6wg";
    public String saucelabs_username = "";
    public String saucelabs_accesskey = "";

    //1 ******************   ********************************************************
    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("OS X") String os, @Optional("10") String os_version, @Optional("chrome-options") String browserName, @Optional("34")
                              String browserVersion, @Optional("http://www.amazon.com") String url)throws IOException {
        //System.setProperty("webdriver.chrome.driver", "/Users/peoplentech/eclipse-workspace-March2018/SeleniumProject1/driver/chromedriver");
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        }else{
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.get(url);
        //driver.manage().window().maximize();
    }
    //2  ****************** getLocalDriver   ********************************************************
    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver","../Generic/driver/chromedriver");
                //chromedriver is inside the driver and driver is inside the Generic module
                // Follow MafiSystem.setProperty("webdriver.chrome.driver","../Generic/browser-driver/chromedriver");
                // (if want to use the absolute path)System.setProperty("webdriver.chrome.driver","/Users/abc/IdeaProjects/unWebAutoMationSep2020titled/driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");            }
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-options")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Windows")){
                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");
            }
            driver = new ChromeDriver(options);
        } // now I will try to use the Geckodriver to see if it is working or not
        else if(browserName.equalsIgnoreCase("firefox")){
            if(OS.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver","../Generic/driver/geckodriver" );
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();        }
        return driver;
    }
    // 3 Mafi already set up another class(DesiredCapabilities) with all of the required properties
    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    //4 Mafi already set up another class(DesiredCapabilities) with all of the required properties
    @AfterMethod
    public void cleanUp() {
        //driver.close();
    }
    //5 ******************   ********************************************************

    public void clickOneElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).click();
                }
            }

        }
    }

    //6 ******************  I created my owne Method  ********************************************************
    // if we have another like same method
//    public void typeOnElement(String locator, String value) {
//        try {
//            driver.findElement(By.cssSelector(locator)).sendKeys(value);
//        } catch (Exception ex) {
//            try {
//                driver.findElement(By.className(locator)).sendKeys(value);
//            } catch (Exception ex2) {
//                try {
//                    driver.findElement(By.id(locator)).sendKeys(value);
//                } catch (Exception ex3) {
//                    driver.findElement(By.xpath(locator)).sendKeys(value);
//                }
//            }
//        }
//    }
    //7 ******************  I created my owne Method  ********************************************************
    //helper methods
//    public void clickOnElement(String locator){
//        try {
//            driver.findElement(By.cssSelector(locator)).click();
//        }catch (Exception ex){
//            try {
//                driver.findElement(By.className(locator)).click();
//            }catch (Exception ex2) {
//                try {
//                    driver.findElement(By.id(locator)).click();
//                } catch (Exception ex3) {
//                    driver.findElement(By.xpath(locator)).click();
//                }
//            }
//        }
//    }
    //8 ******************  I created my own Method  ********************************************************
//    public void typeOnElement(String locator, String value){
//        try {
//            driver.findElement(By.cssSelector(locator)).sendKeys(value);
//        }catch (Exception ex){
//            driver.findElement(By.id(locator)).sendKeys(value);
//        }
//    }
    //*********** the method if you want to use the keyboard   from the computer *******************
//    public static void typeOnElementNEnter(String locator, String value) {
//        try {
//            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
//        } catch (Exception ex1) {
//            try {
//                System.out.println("First Attempt was not successful");
//                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
//            } catch (Exception ex2) {
//                try {
//                    System.out.println("Second Attempt was not successful");
//                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
//                } catch (Exception ex3) {
//                    System.out.println("Third Attempt was not successful");
//                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
//                }
//            }
//        }
//    }
    //9 ******************  I created my owne Method  ********************************************************

    //    public static void typeOnElementNEnter(String locator, String value,WebDriver driver1) {
//        try {
//            driver1.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
//        } catch (Exception ex1) {
//            try {
//                System.out.println("First Attempt was not successful");
//                driver1.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
//            } catch (Exception ex2) {
//                try {
//                    System.out.println("Second Attempt was not successful");
//                    driver1.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
//                } catch (Exception ex3) {
//                    System.out.println("Third Attempt was not successful");
//                    driver1.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
//                }
//            }
//        }
//    }

    //10 If you want to clear the field where we type *********** for example you enter in the searchbar but now you want to clear that searchbar*****************
//    public void clearField(String locator) {
//        driver.findElement(By.id(locator)).clear();
//    }

    //11 ****************** void clearField () method   ********************************************************
    public void clearField(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    //12 If you want to clear the field where we type ****************************

    public void navigateBack() {
        driver.navigate().back();
    }
    //13 ******************   ********************************************************
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            //FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
            ;
        }

    }
    //14 I need to know about this method ***************** ******************************************************
    // We need this method at the time of Extent Reporting********

//    public static String convertToString(String st) {
//        String splitString = "";
//        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
//        return splitString;
//    }
    //15 I need to know about this method ***************** ******************************************************

    public static void clickOnElement(String locator, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver1.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver1.findElement(By.id(locator)).click();
            }
        }
    }
    //16 ******************   ********************************************************
    public void typeOnInputField(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }

    }
    //17 ******************   ********************************************************

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
    //18 ******************   ********************************************************

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    //19 ******************   ********************************************************
    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    //20 ******************   ********************************************************

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    //21 ******************   ********************************************************

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    //22 ******************   ********************************************************

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }
    //23  ******************   ********************************************************
// This method is to read data
    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    //-------------------------------------
    //24 I need to know about this method ***************** ******************************************************

    public List<WebElement> getListOfWebElementsByCs(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }
    //25 ******************   ********************************************************
//This method to convert data or web element into text
//    public static List<String> getTextFromWebElements(String locator) {
//        List<WebElement> element = new ArrayList<WebElement>();
//        List<String> text = new ArrayList<String>();
//        element = driver.findElements(By.cssSelector(locator));
//        for (WebElement web : element) {
//            String st = web.getText();
//            text.add(st);
//        }
//
//        return text;
//    }
    //26 ******************   ********************************************************
    public static List<String> getTextFromWebElements(String locator, WebDriver driver1) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver1.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }

        return text;
    }
    //27 ******************   ********************************************************
//    // (String locator) meaning that when we use this method that time we can put the path of the locators
//    public static List<WebElement> getListOfWebElementsByCss(String locator) {
//        List<WebElement> list = new ArrayList<WebElement>();
//        list = driver.findElements(By.cssSelector(locator));
//        return list;
//    }
    //28 ******************   ********************************************************
    public static List<WebElement> getListOfWebElementsByCss(String locator, WebDriver driver1) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver1.findElements(By.cssSelector(locator));
        return list;
    }
    //29 ******************   ********************************************************

    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }
    //30 ******************   ********************************************************

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
    //31 ******************   ********************************************************

    public void navigateForward() {
        driver.navigate().forward();
    }
    //32 ******************   ********************************************************

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    //33 ******************   ********************************************************

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    //34 ******************   ********************************************************

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }
    //35 ******************   ********************************************************

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    //36 ******************   ********************************************************

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }
    //37 ******************   ********************************************************

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    //38 ******************   ********************************************************

    public static void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
    //39 ******************   ********************************************************
    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }
    // 40******************   ********************************************************

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }
    //41 ******************   ********************************************************
    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //42 ******************   ********************************************************

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //43 ******************   ********************************************************

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }
    //44 ******************   ********************************************************

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }
    // 45******************   ********************************************************

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    //46 ******************   ********************************************************

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file, new File("screenShots.png"));
    }
    //47 ******************   ********************************************************40

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //48 ******************   ********************************************************
    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //49 ******************   ********************************************************

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //50 ******************   ********************************************************

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    //51 ******************   ********************************************************

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }
    //52 ******************   ********************************************************

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    //53 ******************   ********************************************************
    //Handling New Tabs
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        return driver1;
    }
    //54 ******************   ********************************************************
    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        boolean value = driver1.findElement(By.cssSelector(locator)).isDisplayed();
        return value;
    }
    // 55******************   ********************************************************
    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }
}

// Index with the method name and line number
//1     public void setUp                   line Number                                 45
//2     public WebDriver getLocalDriver                                                 64
//3     public WebDriver getCloudDriver                                                  96
//4     public void cleanUp()                                                           117
//5     public void typeOnElement(String locator, String value)                         139
//6     public void clearField(String locator)                                          224
//7     public void navigateBack()                                                      230
//8     public static void captureScreenshot(WebDriver driver, String screenshotName)   234
//9     public static void clickOnElement(String locator, WebDriver driver1)            258
//10    public void typeOnInputField(String locator, String value)                      270






//29     public List<String> getListOfString(List<WebElement> list)                     402
//55        public void typeOnInputBox(String locator, String value)                    761





































//    @Test
//    public void testGettheBasicInfo(){
//        System.out.println("Sajad wants to get the Title of the Page:  "+driver.getTitle());
//        System.out.println("Sumaira wants to get the class:     "+driver.getClass());
//        System.out.println("Bladmir wants to get the current url of the page:   "+driver.getCurrentUrl());
//
//    }


//    @BeforeMethod
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
//        driver = new ChromeDriver();
////        System.setProperty("webdriver.gecko.driver","/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
////        driver= new FirefoxDriver();
//
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        //driver.get("https://www.walmart.com/");
//        //driver.get("https://www.amazon.com/");
//        //driver.get("https://www.cnn.com/");
//        driver.manage().window().maximize();
////        System.out.println("Sajad wants to get the Title of the Page:  "+driver.getTitle());
////        System.out.println("Sumaira wants to get the class:     "+driver.getClass());
////        System.out.println("Bladmir wants to get the current url of the page:   "+driver.getCurrentUrl());
//    }