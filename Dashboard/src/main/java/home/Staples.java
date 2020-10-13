package home;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Staples extends CommonAPI {
    @Test
    public void testGetOfficeSupplyFromStaple() {
        System.out.println("Abdu, Sajad's friend want to get the Title of the page: " + driver.getTitle());
        List<String> readyItems = getOfficeItems();
        for (int i = 0; i < readyItems.size(); i++) {

            typeOnElement("#searchInput",readyItems.get(i)+ Keys.ENTER);
            clearField("#searchInput");
        }
    }
    // I want to go to the Staples to buy the printer ink, printer paper, hp laptop, and fax machine.
    // There are few items it is a list of items
    public List<String> getOfficeItems() {
        List<String> addItems = new ArrayList<String>();
        addItems.add("Printer ink");
        addItems.add("printer paper");
        addItems.add("hp laptop");
        addItems.add("fax machine");
        return addItems;
    } // I added the item on my List now I will create a test
}
