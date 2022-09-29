package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        login();
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        table();

    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
        -- tabloda <table> tagi altinda tablonun basligini gosteren <thead> tagi bulunur
        -- eger baslikta satir(row) varsa <thead> tagi altinda <tr> (satir-row) tagi vardir
        -- ve basliktaki sutunlara yani hucrelere(cell) de <th> tagi ile ulasilir
        -- basligin altindaki tablodaki verilere <tbody> tagi ile altindaki satirlara (row)
        -- <tr> tagi ile sutunlara yani hucrelere <td> tagi ile ulasiriz
         */

        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr/th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body = " + body.getText());

        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki Satır sayısı : "+satirList.size());

        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("Tablodaki 4. satır : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());

        // 5. email başlığındaki tüm elementleri(sutun) konsolda yazdırınız.
        // her satırdaki 3. datayı istiyor bizeden.
        // önce email başlığının kaçıncı sutunda olduğunu bulalım.

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//tead//tr[1]/th")); // başlıkları listeye koyduk
        int emailSutunNo = 0;

        for (int i = 0; i < basliklarListesi.size(); i++) {
            if(basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo = i;
            } // başlıkları forloop ile gözden geçirip, bu başlıklardan hangisinin değeri "Email" ise onun sutununu kaydettik
        }

        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        // (emailSutunNo+1) ==> yapmamızın sebebi; list'imizin index'i 0'dan başlıyor, Table'ımızın index'i 1'dan başlıyor'
        // //tbody//td[3] olarak yazsaydık sonuç aynı olurdu. amacımız kodu dinamik yapmak

        for (WebElement each : emailSutunListesi) {
            System.out.println(each.getText());
        }

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//input[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
        /*
        <table>                 ===>>>> table
            <thead>             ===>>>> header (başlık)
                <tr>            ===>>>> table rows (satırlar)
                    <th> </th>  ===>>>> table header dat (başlıktaki datalar)
                </tr>
            </thead>
            <tbody>             ===>>>> table body
              <tr>              ===>>>> table row
                <td></td>       ===>>>> table data-cell (hücre)
              </tr>
            </tbody>
        </table>

        *** Tablolarda sutun yapısı yoktur. table ==> thead ==> tr ==> th   (tablo ==> başlık ==> satır ==> data)
         */
        /*
        tablo body'nin 3. satırının 5. cell'ine ulaşmak için ==> //tbody//tr[3]//td[5]

        başlıktaki ilk stırdaki tüm detaylar ==> //tbody//td[4]

        Eğer verilen satır ve sutun numarasına göre dinamik bir locate yapmak istersek;
                "//tbody//tr["+satir+"]//td["+sutun+"]"
         */