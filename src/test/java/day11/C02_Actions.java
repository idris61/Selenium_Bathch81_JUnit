package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions = new Actions(driver);
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Erol");
        actions.sendKeys(Keys.TAB).
                sendKeys("Evren").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("evren@gmail.com").
                sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}

    /*
                ÖNCEKİ DERSTEN AKLIMIZDA KALANLAR
     1- TestBase Class : Her test class'ında tekrar tekrar yazdığımız setup ve teardown methodları tekrar yazmaktan
        kurtulmak için Java OOP konsept'i kullanarak oluşturduğumuz bir class'dır.
        - Test Base'i parent olarak kabul eden class'lar hazırlık için oluşturduğumuz driver, setup() ve teardown()
          oluşturmak zorunda kalmazlar, kendilerinde olmasa bile parent class'dan kullanılmış olur.

        - Test Base genelde testlerden farklı bir package'de olduğundan driver'ı kullanabilmek için
          public veya protected yapmamız gerekir.Biz hep child class'lardan kullanacağımız için protected yapmayı
          tercih ettik.

        - Bu class sadece child class'lardan inheritance özellikleri ile kullanılsın istediğimizden, bu class'ın
          obje oluşturularak kullanılmasına engel olmak için class'ı abstact YAPABİLİRİZ.
      2- Actions Class : Selenium'daki Actions class'ı mouse ve klavye ile yapabildiğimiz eylemleri driver ile
         yapabilmemize imkan tanır.

           - Mouse Base Actions:
                click(), contextClick(), doubleClick(), clickAndHold(), dragAndDrop(),moveToElement()

           - Keyboard Base Actions:
                keyDown(), keyUp(), sendKeys()

         Actions class'ini kullanabilmek için actions objesi oluşturup, parametre olarak driver'imizi eklemeli,
         en sona da perform() demeyi unutmamalıyız.
     */