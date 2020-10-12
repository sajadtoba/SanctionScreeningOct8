package home;

import base.CommonAPI;
import base.OldCommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DEFAmazon extends CommonAPI {

    @Test
    public void test1() throws InterruptedException {
        //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("books best sellers");
        //driver.findElement(By.cssSelector(".nav-input")).click();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
       // driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
        System.out.println("Sajad wants to get the Title   :" + driver.getTitle());
    }
    //******************** By Using the Enum key ***********************************
    @Test
    public void test2UsingEniumKey(){
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("apple watches", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("table lamp", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("computer", Keys.ENTER);
    }
    //********************      **********************************************************************



}
