package newsHome;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CnnTest extends CommonAPI {
    @Test
    public void newsUpdated() throws InterruptedException {
        // open the Cnn and open the business tab
        driver.findElement(By.name("business")).click();
        Thread.sleep(2000);
    }
}
