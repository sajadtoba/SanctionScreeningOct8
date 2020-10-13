package home;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonUsingCommenAPIMethodsOld extends CommonAPI {

    @Test
    public void test1() {
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
    }


}





        // Creating a new rf variable from the List interface and save or store the data from the method by calling that method
        //List <String> list = getItem(); // we are creating the rf of the (List) interface and initializing with the getItem below method
        //We already have all of the data information saved inside the new created variable is called list
        // We are able to use the for loop that we can run one by one item
//        for(int i = 0; i < list.size(); i++){
//            driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
//            driver.findElement(By.cssSelector("#twotabsearchtextbox")).clear();
//
//        }




    // Create a return type with multiple items retun  (it will be list, and ArrayList)
    // we need to create the reference variable for he List then we can add the items by using the rf for the List


//    @Test
//    public List<String> getItem(){
//        List<String> itemsList = new ArrayList<String>();
//        itemsList.add("cd player");
//        itemsList.add("Table fans");
//        itemsList.add("bedsheet");
//        itemsList.add("laptops");
//        return itemsList;
//
//
//    }







