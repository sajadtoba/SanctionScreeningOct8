package home;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class AmazonHome extends CommonAPI {
    // This class runs good
     // And below is the commited some codes and they are working fine.
    @Test
    public void test2() {
        System.out.println(driver.getTitle());
        List<String> list = getItems();
        for (int i = 0; i < list.size(); i++) {
            typeOnElement("#twotabsearchtextbox", list.get(i)+Keys.ENTER);
            //clearField("//input[@id='twotabsearchtextbox']");
            clearField("#twotabsearchtextbox");

        }
    }

    public List<String> getItems() {
        List<String> itemList = new ArrayList<String>();
        itemList.add("Heaters");
        itemList.add("Table lamps");
        itemList.add("laptops");
        itemList.add("Desktop computers");
        itemList.add("stools");
        return itemList;
    }
}



// Below is the click method if the above click method does not work
// driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
// clickOnElement(".nav-input");
// Below is the only Type inside the field (search bar window
// typeOnElement("#twotabsearchtextbox", list.get(i));

//typeOnElement("#twotabsearchtextbox", list.get(i));
//            clickOnElement(".nav-input");







