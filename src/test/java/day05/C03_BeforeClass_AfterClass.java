package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {
    /*
    BeforeClass ve AfterClass notasyonları kullanıyorsak oluşturacağımız method'u static yapmamız gerekiyor.

    *** - önce BeforeClass çalıştı,
        - sonrasında methodları sırasıyla AYNI SAYFADA çalıştırdı
        - son olarak AfterClass'ı çalıştırdı

    *** Çalışmasını istemediğimiz test için; Test notasyonunun altına @Ignore notasyonu yazılır.

    Olusturdugumuz test class'inin icindeki test method'lari hep ayni web sitesi ile ilgili ise
    her seferinde yeniden driver olusturmaya
    ve her method icin bu driver'i kapatmaya gerek yoktur
    Class'in basinda bir kere setup calisip, en sonda kapansa olur dersek BeforeClass ve AfterClass kullaniriz

     */
    /*
    NOT-1 : JUnit'te methodların hangi sıraya göre çalışacağına biz karar veremiyoruz. JUnit'in dezavantajı / kafasına göre takılıyor.
    NOT-2 : TestNG harf sırasına göre methodları çalıştırıyor. Öncelik bildiren priority notasyonu kullanarak da öncelik sırası belirlenebilir.
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method1(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://www.hepsiburada.com");
    }
}
