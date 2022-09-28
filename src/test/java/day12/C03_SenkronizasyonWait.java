package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void imlicitlyWaitTest1() {
        //Bir class olusturun : WaitTest
        //Iki tane metod olusturun : implicitWait() , explicitWait()
                  /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's gone!\"]")).isDisplayed());
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitWaitTest2() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
        /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */
        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        //It’s back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());

    }
}
    /*
    Selenium'da Senkronizasyonu nasıl sağlarız?

    Waitler ile 3 çeşit Wait Vardır.
    1) Thread.sleep(3000);  Java tabanlı waittir. Kodları yazılan süre kadar bekler,Süre dolduktan sonra alt satıra geçer.

    2) İmplicitly Wait: Selenium tabanlı waittir.  Sayfadaki tüm öğeler için global bir zaman aşımıdır.(timeout)
    Arkadaşım 10 dakika içinde gelirse beraber gideriz, 10 dakikadan önce gelirse yine beraber gideriz,
    10 dakika içinde gelmezse ben eve dönerim. :) İmplicitlyWait
    Her işlem için tanıdığımız süre kadar bekler, işlem daha önce biterse devam eder.
    Bekle dediğimiz sürece bulamazsa "NoSuchElemtExeption" hatasını verir.

    Implicitly wait’i TestBase class’ımızda kullanıyoruz.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    Bu kod, driver’in sayfadaki herhangi bir weblement için maximum10 saniye beklemesini istediğimiz anlamına gelir.
    Webelement 10 saniye içinde yüklenmezse, test case başarısız olur ve NoSuchElementExeption uyarısı verir.

    Not : Implicitly wait ile çözülebilecek durumlar için, explicitlyWait kullanıma ihtiyaç yoktur.

    3) Explicit Wait: Selenium tabanlı waittir. Çoğunlukla belirli öğeler için belirli bir koşul(expected condition) için kullanılır.
    Arkadaşın gelene kadar bekle, gelince beraber gidin. Dosya indirilinceye kadar bekle.
    Nadiren karsimiza cikan ve daha fazla bekleme süresi gerektiren belirli öğeler(webelement) için explicitly wait kullanılır.

    İlk olarak belirli miktarda bekleme süresi ile wait object create edilir.
        WebDriverWait wait = newWebDriverWait(driver,Duration.ofSeconds(20));

    Olusturdugumuz wait objesi sayesinde WebDriverWait class’indan until( ) method’u ile birlikte
    ExpectedConditions Class’ini kullanabiliriz. Ornegin WebElement’i locate etmek icin wait object’i kullanma
        WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("...")));
     */

