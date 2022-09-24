package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {

    /*
                    ÖNCEKİ DERSTEN AKLIMIZDA KALANLAR
     1- File : Selenium, WebDriver üzerinden çalıştığı için bizim bilgisayarımızdaki dosyalar ile ilgili test yapamaz.
        Ancak bazı testlerimizi çalıştırırken bilgisayarımızda bir dosyanın var olup olmadığını kontrol etmemiz,
        bir dosyayı okumamız veya indirdiğimiz bir dosyanın indirilip indirilmediğini kontrol etmemiz gerekir.
            Bu durumda Java imdadımıza yetişir.
            Ancak Java'nın bilgisayarımızdaki dosyalara erişmek için dosya yoluna (path) ihtiyacı vardır.
            Her bilgisayarın ismi ve user ismi birbirinden farklı olacağından, eğer sabit bir dosya yolu yazarsak,
            bir bilgisayarda çalışan test diğerinde çalışmaz. Bunun için dosya yolunun dinamik olması tercih edilir.

            Dosya yolunu dinamik yapmak için, herkesin bilgisayarında farklı olan kısım ve herkesin bilgisayarında aynı
            olan kısımları concate etmemiz gerekir.
                herkeste farklı olan ==> System.getProperty("user.home")
                herkeste aynı olan   ==> \\Dekstop\\dosyaAdı.dosyaUzantısı
     2- Dosyanın bilgisayarımızda olduğunu test etmek için
                Files.exists(Paths.get(dosyaYolu)) ==> true veya false döner
     3- Dosya upload : Bilgisayarımızdaki klasörleri mouse ile açamayacağımız için, dosya seç butonunu locate edip
                button.sendKeys(dosyaUolu) diyerek dosyayı seçip, sonra file upload butonuna basıyoruz.

     */

    @Test
    public void test() {

    // https://the-internet.herokuapp.com/upload adresine gidelim
    driver.get("https://the-internet.herokuapp.com/upload");

    // Dosyasec butonuna basalim
    WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='file-upload']"));

    // Yuklemek istediginiz dosyayi secelim
    String dosyaYolu = "C:\\Users\\idris\\Desktop\\text.txt";
    dosyaSec.sendKeys(dosyaYolu);

    // Upload butonuna basalim
    driver.findElement(By.xpath("//*[@id='file-submit']")).click();

    // “File Uploaded!” textinin goruntulendigini test edelim.
    Assert.assertTrue(driver.findElement(By.xpath("//*[h3='File Uploaded!']")).isDisplayed());

    }

}

