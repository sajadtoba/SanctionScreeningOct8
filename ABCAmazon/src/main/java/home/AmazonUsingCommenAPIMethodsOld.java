package home;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AmazonUsingCommenAPIMethodsOld extends CommonAPI {

    @Test
    public void test1() {
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
    }


    }



