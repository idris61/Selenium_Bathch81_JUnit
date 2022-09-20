package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    /*
                Önceki Dersten Aklımızda Kalanlar
    1- JS Allerts : Web sitelerinde iki tür alert vardır.
        1- HTML Allerts : sağ click yapıp incelenebilir, dolayısıyla diğer elementler gibidir.
        2- JS Allerts : bunlar sağ click yapılıp incelenemez, dolayısıyla da diğer WebElementler'den farklıdır.

        Bunlarla çalıiabilmek için driver.switchTo().alert() method'u ile alert'e geçip, ondan sonra
        accept, dismiss, sendKeys veya getText() methodlarından uygun olanı kullanılır.

        Ard arda bile olsa alert ile işlem yapmak istediğimiz her seferde switchTo() kullanmalıyız.

    2- BasicAuthentication : Normal olarak web sitelerinde login fonksiyonu için kullanıcı adı ve şifre webelementlerine
    bilgileri girip, login butonuna basarız.

       Ancak bazı websitelerinde ve özellikle API haberleşmesinde kullanıcı adı ve şifreyi manuel olarak tek girmek yerine,
       servis sağlayıcının bize vereceği bilgiler doğrultusunda, kullanıcı adı ve şifreyi URL'e ekleyebiliriz.
       Böylece sayfaya gitme ve login fonksiyonu tek adımda halledilmiş olur.

    3- iframe : Bir web sayfasının içinde, kaynak olarak başka web sayfasının çalıştığı bölüm oluşturmak için HTML'de
    iframe oluşturulur.

       Her bir iframe kendi içinde bir web sayfasi gibi HTML kodlarından oluşur. (html.head ve body tagları gibi)

       Eğer bir webelementi doğru olarak locate etmemize rağmen, driver o webElement'i bulanıyorsa,
       webElement iframe içerinde olabilir. Bu durumda HTML kodlarını incelememiz gerekir.

       Eğer bir webElement iframe içerisindeyse önce o iframe'e driver.switchTo().Frame(switch Yöntemi) ile geçmeliyiz.

       3 şekilde iframe' geçiş yapabiliriz.
            - index
            - name/id
            - webElement olarak tanımlayarak

       iframe, alert'ten farklıdır. switchTo() ile iframe geçince oradan çıkıncaya kadar driver o iframe'de kalır ve
       bu sürede asıl sayfadaki webElementleri göremez.

       iframe'den çıkmak için 2 yöntem vardır.
            - defaultContent() ==> ana sayfaya çıkar
            - parentFrame() ==> bir üst frame'e çıkar.(iç içe iframe olan sayfalarda kullanılabilir.)
     */
    /*
     ● Bir class olusturun: IframeTest
     ● https://the-internet.herokuapp.com/iframe adresine gidin.
     ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
          dogrulayin ve konsolda yazdirin
  */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isEnabled());
        System.out.println(iframeYazisi.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr")); // Frame'e geçiş yapmadan önce orayı id ile locate ederiz
        driver.switchTo().frame(textBox); // Locate ettiğimiz frame geçmek için bu methodu kullanırız
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear(); // Clear methodu text box'ın içini temizler
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");

        /*
        textBox'ı doğru olarak locate etmemize rağmen driver bulamadı. Bunun üzerine HTML kodları inceleyince
        textBox'ın aslında bir IFrame içerisinde olduğunu gördük
        Bu durumda önce IFrame'i locate edip  switchTo() ile o IFrame geçmeliyiz.
         */

        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent(); // Iframe'den çıkıp ana sayfaya geçmek için bu method kullanılır
        WebElement elemantal = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemantal.isDisplayed());
        System.out.println(elemantal.getText());

        /*
        link yazi elementini doğru locate etmemize rağmen yazdırmadı. Çünkü yukarıda IFrame e geçiş yapmıştık.
        önce IFrame den çıkmamız lazım.
        Iframe’den cikmak icin 2 komut vardir;
        driver.switchTo().parentFrame();      ==> 1 ust seviyedeki frame’ecikartir
        driver.switchTo().defaultContent();   ==> En ustteki frame’e cikmak icinkullanilir
         */
    }
}