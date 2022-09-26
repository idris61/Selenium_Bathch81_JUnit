package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    - url'in "amazon" icergini test et
    - title'in "facebook" icermedigini test et
    - sol ust kosede amazon logosunun gorundugunu test et
     */


    /*
    Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
          BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.

          BeforeAfter methodunda methodların static yapmaya gerek yok ama
          BeforeAfterCLass'da static yapmak zorunlu.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
        //a-Url'nin facebook içerdiğini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //Assert.assertNotEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test2(){
        //b-Title'in facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }
}

    /*
    Eğer Test method'umuzda hiçbir test yoksa (doğrulama, karşılaştırma..vs), test çalıştıktan sonra hiç bir problemle
    karşılaşılmadığını raporlamak için "test passed" yazısı çıkar.

    Eğer testleri if ile yaparsak,
    test failed olsa bile kodlar problemsiz çalıştığı için kod çalışması bittiğinde ekranın sol alt kısmında
    test passed yazacaktır.
     */
    /*
    Assert ile yaptığımız testlerde assertion failed olursa Java kodların çalışmasını durdurur ve Assert class'i
    bizi hata konusunda bilgilendirir.

     */

    /*

    1. assertEquals
    assertEquals , beklenen sonucu gerçek sonuç ile karşılaştırmak için kullanılır.
    Beklenen sonuç ile gerçek sonuç eşit değil ise gerçekleştirilen test senaryosu sonucunda assertionError hatası fırlatır.

    2. assertTrue
    assertTrue, beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    Parametre olarak iki değer alır. İlk parametre de bir mesaj gönderilir ikinci parametrede ise
    gönderilen mesajın doğruluğu için koşul belirlenir.

    3. assertFalse
    assertFalse, beklenen bir sonucun false olması durumunda kullanılır. İki parametre alır.
    Parametrelerden biri mesajdır diğeri ise koşuldur. assertFalse ile koşul yerine getirilmez ise
    assertionError hatası fırlatır.

    4.assertNull
    assertNull, beklenen bir sonucun null olup olmadığı kontrol edilmesi için kullanılır.
    Bir nesneyi parametre olarak alır ve nesne null değil ise assertionError hatası fırlatır.

    5.assertNotNull
    assertNotNull, beklenen bir sonucun null olmadığını doğrulamak için kullanılır. Bir nesneyi parametre olarak alır ve
    nesne null ise assertionError hatası fırlatır.

    6.assertSame
    assertSame, parametre olarak verilen iki nesnenin aynı nesneye karşılık gelip gelmediğini kontrol eder.
    Eğer nesneler aynı nesneyi karşılamıyor ise assertionError hatası fırlatır.

    7.assertNotSame
    assertNotSame, parametre olarak verilen iki nesnenin birbirine eşit olmadığı kontrolünü eder.
    Eğer aynı nesneye karşılık geliyor ise assertionError hatası fırlatır.

    8.assertArrayEquals
    assertArrayEquals, parametre olarak verilen iki dizinin eşit olup olmadığını kontrol eder.
    Her iki dizi içinde null değeri var ise bunlar eşit olarak kabul edilir. Eğer eşit değil ise
    assertionError hatası fırlatır.

     */
