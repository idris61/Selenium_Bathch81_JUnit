package A_1_Maven_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Q03_Maven_TekrarTesti {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1-C01_Tekrar Testi isimli bir class olusturun
        // 2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3-cookies uyarisini kabul ederek kapatin
        // 4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")) {
            System.out.println("Baslik testi PASSED");
        } else {
            System.out.println("Baslik testi FAILED");
        }

        // 5-Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella"+ Keys.ENTER);

        // 6-Bulunan sonuc sayisini yazdirin
        String [] sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
        System.out.println("Sonuc Yazisi : " + Arrays.toString(sonucYazisi));   // Sonuc Yazisi : [Yakla��k, 141.000.000, sonu�, bulundu, (0,55, saniye)]
        System.out.println("Sonuc Sayisi : " + sonucYazisi[1]);                 // Sonuc Sayisi : 141.000.000
        String sonucYazisi1 = sonucYazisi[1].replaceAll("\\D","");

        int sonucSayisi = Integer.parseInt(sonucYazisi1);
        System.out.println("integer sonuc sayisi : " + sonucSayisi);           // integer sonuc sayisi : 141000000

        // 7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if (sonucSayisi>10000) {
            System.out.println("Sonuc testi PASSED");
        } else {
            System.out.println("Sonuc testi FAILED");
        }

        // 8-Sayfayi kapatin
        driver.close();

    }
}
