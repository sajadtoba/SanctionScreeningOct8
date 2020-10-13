package home;
import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
// Creating a new variable and initialize with the added items (returned items)
// TypeOnElment() method has 2 parameters
public class Walmart extends CommonAPI {
    @Test
    public void testGetOfficeSupplyFromWalmart(){
        System.out.println("Sajad wants to get the page Title: "+ driver.getTitle());
        List<String> listreturnedItems = getOfficeSupply();
        for(int i =0; i<listreturnedItems.size(); i++){
            typeOnElement("#global-search-input",listreturnedItems.get(i)+Keys.ENTER);
            clearField("#global-search-input");
        }
    }
    public List<String> getOfficeSupply() {
        List<String> mylist = new ArrayList<String>();
        mylist.add("Printer ink");
        mylist.add("hp scanner");
        mylist.add("printer paper");
        return mylist;
    }
}
//    // Below just checking if the cssSelector locator is working fine or not?
//    @Test
//    public void searchItems() {
//        driver.findElement(By.cssSelector("#global-search-input")).sendKeys("Bread");
//    }