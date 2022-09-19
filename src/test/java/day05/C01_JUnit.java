package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {
    /*
    MAIN METHOD DÖNEMİ BİTMİŞTİR...

    Şimdiye kadar Java'da bir class'in calismasi icin main method sarttir diyorduk
    @Test notasyonu ile bu mecburiyet bitti

    @Test notasyonu olmayan method'lar bugune kadar yaptigimiz gibi sadece cagrildiklarinda calisir
    Ancak @Test eklendiginde bagimsiz calisabilir hale gelir
     */
    /*
    pom.xml ile istediğimiz kütüphaneleri eklemek, çıkarmak, update etmek çok kolaydır. onun için maveni tercih ederiz.
    maven i maven yapan pom.xml dir.

    Java ile en temel framework JUnit ile oluşturulabilir.
    JUnit'te test yapmak için hazır metodlar var.

    Aklımızda Kalanlar:
    1- Maven : build tool, proje yönetim aracıdır.
    2- Maven'in yola çıkış amacı proje geliştirmenin kolaylaştırılması ve birlikte çalışmanın sağlanmasıdır.
    3- Selenium, browserları otomasyon yapabilmemiz için gerekli tool'ları çalıştıran bir suite'dir.
    4- Maven Java projelerin geliştirilmesi için , ihtiyacımız olan tüm tool'ları projemize eklemek, update etmek,
       versiyonlarını değiştirmek gibi işlemleri kolayca yapmamızı sağlayan bir build tool'dur.
    5- Maven bu işlemleri nasıl sağlar?
       - Maven'in kalbi pom.xml'dir.
       - pom.xml'e ekleyeceğimiz dependency'ler ile istediğimiz her kütüphaneyi projemize kolaylıkla ekleyebiliriz.
       - projemiz için kullanmak istediğimiz dependency'leri mvnrepository.com dan alabiliriz.
       - İlgili kütüphanenin hangi versiyonunu yüklememiz gerektiğine karar vermek için en güncel, en çok kullanılan ve
         stable olan versiyonu buluyoruz.
    6- Maven bir framework değildir, sadece framework'u kolayca oluşturmamizi sağlayan bir tool'dur. Biz selenium
    dersleri boyunca 3 farklı framework ile çalışacağız.
       - JUnit
       - TestNG
       - Cucumber
     */
    @Test
    public void method1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
    }
    @Test
    public void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.hepsiburada.com");
    }



}
