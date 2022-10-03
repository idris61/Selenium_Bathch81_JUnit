package A_2_JUnit_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Q32_WebTablesClassWork extends TestBaseBeforeAfter {
    @Test
    public void test() {

    // login() metodun oluşturun ve oturum açın.
        login3();

    // table() metodu oluşturun
        table3();

    // printRows() metodu oluşturun//tr
        printRows();

    // printCells() metodu oluşturun//td
        printCells();

    // printColumns() metod uoluşturun
        printColumns();

    }
    private void login3() {
        // "https://concorthotel.com/admin/HotelRoomAdmin" adresine gidin
        driver.get("https://concorthotel.com/admin/HotelRoomAdmin");

        // Username:manager
        // Password :Manager1!
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
    private void table3() {

        // Tüm table body’sinin boyutunu(sutun sayisi) bulun./tbody
        List<WebElement> baslikSayisi = driver.findElements(By.xpath("//tbody//th"));
        System.out.println("Sayfanin baslik sayisi : " + baslikSayisi.size());

        // Table’daki tum body’i ve başlıkları (headers) konsolda yazdırın.
        baslikSayisi.forEach(t-> System.out.println(t.getText()));

    }
    private void printRows() {

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> tumBadySatirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("tum Bady'deki Satir Sayisi = " + tumBadySatirSayisi.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        tumBadySatirSayisi.forEach(t-> System.out.println(t.getText()));

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        WebElement doruncuSatir = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("4.satirdaki elemntler :" + doruncuSatir.getText());
    }
    private void printCells() {

        // table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> toplamHucreSayisi = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("toplam Hucre Sayisi = " + toplamHucreSayisi.size());

        // Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        toplamHucreSayisi.forEach(t -> System.out.println(t.getText()));
    }
    private void printColumns() {

        // table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> tumBody =driver.findElements(By.xpath("//thead//tr//th"));

        // Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        System.out.println("sutun sayisi : " + tumBody.size());

        // 5.column daki elementleri konsolda yazdırın.
        tumBody.forEach(t-> System.out.println(t.getText()));
    }

}
