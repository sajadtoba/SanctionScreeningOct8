package home;

import base.OldCommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AmazonHome1 extends OldCommonAPI {


    @Test
    public void test2UsingEniumKey(){
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("printers", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone watches", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("computer", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
    }
}

