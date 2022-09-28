package A_2_JUnit_Tekrar;

import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.logging.SocketHandler;

public class Q20_KeyboardBaseActionsHomework extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {

        // 1-"http://webdriveruniversity.com/Actions"sayfasina gidin
        driver.get("https://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverWE = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverWE).perform();
        Thread.sleep(2000);

        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]")).click();

        // 4- Popup mesajini yazdirin
        System.out.println("Popup mesjai : " + driver.switchTo().alert().getText());
        Thread.sleep(2000);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement ClickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(ClickAndHold).perform();

        // 7- “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(ClickAndHold.getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement DoubleClick = driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(DoubleClick).perform();
    }
}
