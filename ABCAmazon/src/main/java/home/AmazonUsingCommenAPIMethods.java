package home;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AmazonUsingCommenAPIMethods extends CommonAPI {

    @Test
    public void test1() throws InterruptedException {

//        typeOnElement("#twotabsearchtextbox","books best sellers");
//        clickOnElementByxPth("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
        //typeSendAndClickOnElement("#twotabsearchtextbox","iphone");
        //typeSendAndClickOnElement("twotabsearchtextbox","iphone");
        typeSendAndClickOnElement("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]","iphone");




        //          driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("books best sellers");

        //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone");
        //          typeAndClickOnElementBycss("#twotabsearchtextbox","iphone");

        //clickOnElementByxPth("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
        //driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
        System.out.println("Sajad wants to get the Title   :" + driver.getTitle());
    }


}
