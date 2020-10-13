package home;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonGetMultipleItems extends CommonAPI {
    // Does not run good need to look in the Dashboard Amazon Home works fine

        @Test(priority = 0)
        public void test1() throws InterruptedException {
            System.out.println(driver.getTitle());
            List<String> list = getItems();
            for (int i=0; i<list.size(); i++){
                clearField("//input[@id='twotabsearchtextbox']");

                driver.findElement(By.cssSelector("//input[@id='twotabsearchtextbox']")).sendKeys(list.get(i));
                driver.findElement(By.id(".nav-input"));
            }
            Thread.sleep(1000);
        }











        public List<String> getItems(){
        List<String> itemList = new ArrayList<String>();
        itemList.add("books");
        itemList.add("iPhone");
        itemList.add("Honey");
        itemList.add("car");
        return itemList;  // return the reference variable of the item
    }



}














// // We can create a new rf for the List (interface) and initialize with the created method
//    // Now we are able to use the for loop while we have already items
//    // if we want we can create a new variable for the size of the listsize or we can use inside the size method
//
//    @Test
//    public void testSearchMultipleItems() throws InterruptedException {
//        List<String> list = getItems();
//        for (int i=0; i<list.size();i++){
//            //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", list.get(i),Keys.ENTER);
//            //driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(list.get(i),Keys.ENTER);
//
//            driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(list.get(i));
//
//
//
//            driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
//
//
//
//            Thread.sleep(2000);
//        }
//
//
//        //
//
//
//
//
////        @Test(priority = 0)
////        public void test1() throws InterruptedException {
////            System.out.println(driver.getTitle());
////            List<String> list = getItems();
////            for (int i=0; i<list.size(); i++){
////                clearField("//input[@id='twotabsearchtextbox']");
////                typeOnElement("//input[@id='twotabsearchtextbox']",list.get(i));
////                clickOneElement(".nav-input");
////            }
////            Thread.sleep(1000);
////        }
//
//
//
//
//
//
//
//
//    }
//
//
//    // Creating a return type method that we can use inside the test
//    // We created the list
//    // We added the items
//    // Now we need to fetch the size of the created list
//    // we need to create the new variable and initialize with the size
//    // Now we can use for loop after we got the size
//
//
//
//
//    public List<String> getItems(){
//        List<String> itemList = new ArrayList<String>();
//        itemList.add("Heaters");
////        itemList.add("Table lamps");
////        itemList.add("laptops");
////        itemList.add("Desktop computers");
//
////        int listSize = itemList.size();
////        for (int i = 0; i < listSize; i++);
//
//        return getItems();
//    }
//}
//
//
////