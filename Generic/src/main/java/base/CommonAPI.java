package base;

import org.apache.commons.exec.OS;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI { // Belong to the main class
    public WebDriver driver = null;
    // We need to create 2 variables for te browserstack
    public String browserstack_userName = "sajjad65";
    public String browserstack_accessKey = "WKrsTRMyZ4FFSoNPz6wg";
    // We need to create 2 more variables for the SauceLabs

    public String sauceLabs_userName = "";
    public String sauceLabs_accessKey = "";

    //public  static WebDriver driver = null;   // we need to declare Webdriver to run the test inside the Amazon
    // We need 3 methods
    // SetUp always void  method()
    // Inside the Optional we put the value and name  from the runner.xml file
    // inside the @Parameters we use the name from the runner.xml file


    @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv,
                      @Optional("false") String cloudEnvName,
                      @Optional("OS X") String os,
                      @Optional("10") String os_version,
                      @Optional("chrome") String browserName,
                      @Optional("85.0") String browserVersion,
                      @Optional("https://www.amazon.com") String url) throws IOException {

        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName, browserstack_userName, browserstack_accessKey, os, os_version, browserName, browserVersion);
            } else if (cloudEnvName.equalsIgnoreCase("saucelabs")) {
                getCloudDriver(cloudEnvName, sauceLabs_userName, sauceLabs_accessKey, os, os_version, browserName, browserVersion);
            }
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);


    }      // This is just set up when we run from th

    // we need to create the return type method that will return the driver


    public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String os, String os_version,
                                    String browserName, String browserVersion) throws IOException {
        // We are going to use the class name is DesiredCapabilites
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);

        if (envName.equalsIgnoreCase("SauceLabs")) {
            driver = new RemoteWebDriver(new URL("http://" + envUserName + ":" + envAccessKey + "@ondemand.saucelabs.com:80/wd/hub"), cap);


        } else if (envName.equalsIgnoreCase(("Browserstack"))) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUserName + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }


    //**********************************************************************************************************************************
    // Now we need to get the local driver
    // We need to use the ChromeOption Class (to handle the notifications)
    // We created the return type method with 2 parameters ( OS, browserName) OS = Operating System

    // you can use other path Mafi did different way
    //System.setProperty("webdriver.chrome.driver","../Generic/browser-driver/chromedriver.exe");

    // I think window xpath is in different ways
    // We are initializing Chrome browser using Selenium webdriver


    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName) { // Method starts
        // We are using the both Operating Systems OS X and windows to get the Local driver

        if (browserName.equalsIgnoreCase("chrome")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening_Oct112020/Generic/src/main/java/driver/chromedriver");
            } else if (OS.equalsIgnoreCase("Window")) {
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
            }

            driver = new ChromeDriver();
        }

        // How to Handle the Notification for both mac and window
        //***********************Above how to handle the Notifications for both OS operating systems


        else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening_Oct112020/Generic/src/main/java/driver/chromedriver");

            } else if (OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
            }
            //Inside the ChromeDriver class we can call the reference variable of the ChromeOptions Class
            // We are calling another class inside the Class
            driver = new ChromeDriver(options);

        }


        //***********************Above how to handle the Notifications for both OS operating systems


        // I AM GOING TO USE THE GECKODRIVER TO SEE IF IT IS WORKING OR NOT

        else if (browserName.equalsIgnoreCase("firefox")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "/Users/abc/Desktop/SanctionScreening_Oct112020/Generic/src/main/java/driver/geckodriver");
            } else if (OS.equalsIgnoreCase("Window")) {
                System.setProperty("webdriver.gecko.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
            }
            driver = new FirefoxDriver();
        }


        // I am going to use the ie browser for both OS operating systems

        else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.id.driver", "/Users/abc/Desktop/SanctionScreening_Oct112020/ABCAmazon/src/test/resources/InternetExplorerBrowserRunnerOnBrowserstack.xml");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }     // belong to the method start


    public void clearField1(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    // Create a void method with one argument / signature or parameters (String locator) that can clear the typing place
    public void clearField(String locator){
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        }catch (Exception e){
            try{
                driver.findElement(By.xpath(locator)).clear();
            }catch (Exception e1){
                try{
                    driver.findElement(By.name(locator)).clear();
                }catch (Exception e2){
                    try{
                        driver.findElement(By.className(locator)).clear();
                    }catch (Exception e3){
                        try{
                            driver.findElement(By.linkText(locator)).clear();
                        } catch (Exception e4){
                            try {
                                driver.findElement(By.partialLinkText(locator)).clear();
                            } catch (Exception e5){
                                driver.findElement(By.tagName(locator)).clear();
                            }// this is the last no more try block inside
                        } // Belong to the catch(Exception e4) method and code block
                    }// Belong to the catch(Exception e3) method and code block
                }// Belong to the catch (Exception e2) method and code block which
            }// belong to 2nd catch (Exception e1)method and code block
        }// Belong to the 1st catch(Exception e) code block
    }// Belong to the method











//Type on the search bar window by using any type of locators
    // in this case we need void method with create 2 parameters
    // We need to create try and catch because if one is not then we can use the others
    // try id code block only
    // catch has () method and code block

    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception e) { // open the exception and it will close at the end. Inside the exception we can have more try blocks
            // 2nd try
            try { // opened the 2nd try block
                driver.findElement(By.xpath(locator)).sendKeys(value);
            } catch (Exception e1) {                                                 // closed the 2nd try block and 2nd catch starts
                try { // opened the 3rd try block
                    driver.findElement(By.id(locator)).sendKeys(value);
                } catch (Exception e2) {// Closed the try block and starts the catch() and block which closed at the end
                    try { // opend the 4th try block inside the catch block becasue try block open and close but catch still open
                        driver.findElement(By.name(locator)).sendKeys(value);
                    } catch (Exception e3) {// closed the try block and opened the catch block this is the last no more try block needed
                        driver.findElement(By.className(locator)).sendKeys(value);
                    }
                }
            }
        }
    }

//        public void typeOnElement (String locator, String value){
//            try {
//                driver.findElement(By.cssSelector(locator)).sendKeys(value);
//            } catch (Exception ex) {
//                try {
//                    driver.findElement(By.className(locator)).sendKeys(value);
//                } catch (Exception ex2) {
//                    try {
//                        driver.findElement(By.id(locator)).sendKeys(value);
//                    } catch (Exception ex3) {
//                        driver.findElement(By.xpath(locator)).sendKeys(value);
//                    }
//                }
//            }
//        }

    // Create a void signature () method that will help to click by using any type of locators
    public void clickOnElement(String locator) {
        try { // 1st try block open and close then starts catch () and block which close at the end
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {// 1st catch() and block starts that will close at the method
            try { // open 2nd try block and close the 2nd try block then 2nd catch block open and close at the end
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex1) {// 2nd try block closed and 2nd catch () and code block open inside the Exception open try block
                try { // open the 3rd try block and closed then 3rd catch()method and code block open which will close at the end
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex2) {
                    try { // open the 4th try code block and close then 4th catch () method and code block will open
                        driver.findElement(By.className(locator));
                    } catch (Exception ex3) {// closed the 4th try block and opened the catch() and code block
                        driver.findElement(By.name(locator));

                    } // Belong to the last catch(Exception ex3) and code block
                } // Belong to the 3rd catch (Exception ex2) method and code block
            } // Belong to the 2nd catch (Exception ex1) method and code block
        } // Belong to the 1st catch (Exception(ex) method and code block
    } // Belong to the ()method


        public void clickOnElement1 (String locator){
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


    } // Belong to the Class
