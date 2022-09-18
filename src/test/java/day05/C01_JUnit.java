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
