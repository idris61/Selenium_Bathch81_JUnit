package A_2_JUnit_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Q31_WebTablesClassWork extends TestBaseBeforeAfter {
    @Test
    public void test() {

    // login( ) metodun oluşturun ve oturum açın.
       login1();

    // table( ) metoduoluşturun
        table1();

    }

    private void login1() {
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        // Username :manager
        // Password :Manager1!
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
    private void table1() {

        // Tüm table body’sinin boyutunu (sutun sayisi) bulun./tbody
        List<WebElement> sutunList = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi = " + sutunList.size());

        // Table’daki tum body’I ve başlıkları (headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar = " + basliklar);

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body = " + body);

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satir Sayisi = " + satirList.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w: satirList) {
            System.out.println(w.getText());
        }

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }
}
