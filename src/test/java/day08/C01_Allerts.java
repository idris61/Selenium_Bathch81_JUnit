package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
    /*
    Önceki Dersten Aklımızda Kalanlar
    1- Assertion : Selenium'da test edin denilen durumları Selenium Assert Class'indan hazır method'larla yapabiliriz.

       Java'dan kalan if-else ile de test yapılabilir ama JUnit ve sonra kullanacağımız TestNG frameworkleri Assert'e
       göre dizayn edilmiştir.

       Assertion'da öncelikle testimizde bizden istenenin ne olduğunu incelemeliyiz.
       - Eğer bizden istenene iki değerin eşitliğinin test edilmesi ise ==> assertEquals
       - Eğer sonucun olumlu olması (true) bekleniyorsa                 ==> assertTrue
       - Eğer sonucun olumsuz olmasını (false) bekliyorsak              ==> assertFalse

    Assertion'da test FAILED olunca Selenium kodun kalan kısmını çalıştırmaz.
    If-Else kullandığımızda test istenen sonucu yazdırır, testin çalışması durmaz ve testin sonunda kodlar
    normal çalışıp bittiği için test PASSED der.

    2- DropDown Menu : Açılır menu;
        Dropdown bir WebElement'den birden fazla option kullanabilmemizi sağlar
        dropdown ile select tag'i birbirinin ayrılmaz parçasıdır.
        Bir HTML ögesi select tag'ı kullanıyorsa çok büyük bir ihtimalle doropdown'dir.
        Dropdown'da asıl amaç, WebElement'i locate etmek değil, dropdown'da istediğimiz option'ı seçebilmektir.
        Seçme işlemi 3 adımda yapılır.
        - Dropdown webelement'i locate ederiz.
        - Select class'indan bir obje oluşturup, parametre olarak dropdown webelementini yazarız.
        - Dropdown'dan option seçmek için 3 seçenekten birini kullanırız.
                - selectByIndex
                - selectByValue
                - selectByVisibleText
     */
    /*
                  //-/-/ Handle Allerts (Uyarıları Yönet) /-/-//
    AlertNedir?
    Alert kullanıcıya bir tür bilgi vermek veya belirli bir işlemi gerçekleştirme izni istemek için ekran bildirimi
    görüntüleyen küçük bir mesaj kutusudur. Uyarı amacıyla da kullanılabilir.

    HTMLAlerts : Bir alert ciktiginda sag click ile inspect yapabiliyorsak html alert’dir ve extra bir isleme gerek yoktur.

    JsAlerts   : Js alerts inspect yapilamaz, ekstra isleme ihtiyac vardir.

    Handle AllertMethods :
    ● accept( )         => Bir uyarıda(alert) OK'ı tıklamaklaaynı.
                            driver.switchTo( ).alert( ).accept();
    ● dismiss()         => Bir uyarıda(alert) Cancel'ı tıklamaklaaynı.
                            driver.switchTo( ).alert( ).dismiss();
    ● getText()         => Uyarıdaki(alert) mesajı almakiçin.
                            driver.switchTo( ).alert( ).getText();
    ● sendKeys(“Text”)  => Uyarı(alert) text kutusuna text göndermekiçin
                            driver.switchTo( ).alert( ).sendKeys("Text");

     */
    /*
    Herhangi bir web sitesine gidince veya bir web sitesinde herhangi bir işlem yaptığımızda
    ortaya çıkan uyarılara alert diyoruz.

    Eğer bir alert inspect yapılabiliyorsa, o alert otomasyon ile kullanılabilir, bu tür alert'lere HTML alert denir
    ve bunlar için ekstra bir işlem yapmaya gerek yoktur.
    Tüm WebElement'ler gibi locate edip istediğimiz işlemleri yapabiliriz.

    Ancak web uygulamalarında HTML alert yanında java script alert de bulunabilir.
    js alert'ler locate edilemez
    Selenium'da JS alert'ler için özel bir yöntem geliştirilmiştir.
     */

    /*
   - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
   - Click for js Alert butonuna tıklayalım
   - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.close();
    }
       @Test
    public void test1() throws InterruptedException {
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // - Click for js Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
    }

}