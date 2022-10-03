package A_2_JUnit_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Q27_ActionsClassHomeWork extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {

        // 1. "http://webdriveruniversity.com/Actions"sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Thread.sleep(2000);

        // 2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverWE = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOverWE).perform();
        Thread.sleep(2000);

        // 3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

        // 4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // 6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldWE = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHoldWE);

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldWE.getText());

        // 8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).perform();
    }
}
