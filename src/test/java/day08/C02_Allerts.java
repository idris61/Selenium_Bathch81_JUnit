package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sitesine girdiğimizde karşımıza bir uyarı mesayı yada bir buttona tıkladığımızda bir uyarı(alert)
    çıkabilir. Eğer bu uyarıya incele(mause sağ tik-inspect) yapabiliyorsak bu tür alert'lere HTML alert denir
    ve istediğimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdehale(Sağ tik-incele) edemiyorsak bu tür
    alert'lere js alert denir. js alert'lere müdehale edebilmek için
    - tamam yada ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır
     */

    /*
        Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void acceptAlert() throws InterruptedException {

        // Bir metod olusturun: acceptAlert
        // 1. butona tıklayın, uyarıdaki OK (Tamam) butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().accept(); // alert'e geçmek için switchTo() methodunu kullanıyoruz.
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String actualResultYazisi = sonucYazisiElementi.getText();
        String expectedResultYazisi = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultYazisi,actualResultYazisi);
    }
    @Test
    public void dismissAlert() throws InterruptedException {
        // 2. butona tıklayın, uyarıdaki Cancel(iptal) butonuna tıklayın ve result mesajının
        // “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        // Alert üzerindeki mesajı yazdırın
        System.out.println("2. Butonun Alert Mesaji = "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        String actualMesaj = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void sendKeysAlert() throws InterruptedException {

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK(Tamam) butonuna
        // tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Alert üzerindeki mesajı yazdırınız
        Thread.sleep(2000);
        System.out.println("3. Butonun Alert Mesaji : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Erol Evren");
        driver.switchTo().alert().accept();
        String actualMesaj = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedMesaj = "Erol Evren";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }
}