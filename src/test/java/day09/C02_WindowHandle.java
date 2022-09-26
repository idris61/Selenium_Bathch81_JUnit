package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    /*
            /-/-/-/     Handle Windows     /-/-/-/
    ● Bazen bir butona tıkladığımızda, başkabir sekmede(tab) yeni bir pencere açılır.
    ● Birden fazla pencereyle calişirken driver’a pencereler arasında gecis yaptirmamiz gerekir.
    ● Pencereler arasında gecis yapmak icinwindow handle degerini kullaniriz.
    ● window handle : Selenium WebDriver’in, WebDriver objesi başlatıldığında her pencereye verdigi unique alfanumerik kimlik degeridir

        Handle WindowsMethod’lari
    1) Icinde oldugumuz sayfanin window handle degerini alma
            driver.getWindowHandle();
    2) Pencereler arasında geçiş yapma(switch)
            driver.switchTo().window(sayfa1HandleDegeri);
    3) Yeni tab olusturup geçiş yapma(switch)
            driver.switchTo().newWindow(WindowType.TAB);
    4) Yeni window olusturup geçişyapma(switch)
            driver.switchTo().newWindow(WindowType.WINDOW);
    5 ) Acik olan pencerelerin window handle degerlerini alma
            driver.getWindowHandles();
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
        driver.quit();
    }
    @Test
    public void test1() {

        // 1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
        driver'in window handle değerini string bir değişkene atarız
        Sonrasında farklı bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
        String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
         */

        // 2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // 3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere açmak için bu methodu kullanırız
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        // 4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); // Sayfalar arası geçiş için bu method kullanılır
        WebElement searcbox = driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("java", Keys.ENTER);

        // 6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

        // 7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        // 8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());

    }

}