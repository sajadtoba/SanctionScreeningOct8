package base;

import org.apache.commons.exec.OS;
import org.apache.poi.ss.formula.functions.T;
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
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");
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
                System.setProperty("webdriver.chrome.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/chromedriver");

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
                System.setProperty("webdriver.gecko.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
            } else if (OS.equalsIgnoreCase("Window")) {
                System.setProperty("webdriver.gecko.driver", "/Users/abc/Desktop/SanctionScreening/Generic/src/main/java/driver/geckodriver");
            }
            driver = new FirefoxDriver();
        }


            // I am going to use the ie browser for both OS operating systems

         else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.id.driver", "I need to get the driver");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }     // belong to the method start


} // Belong to the Class
