package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

                    //-/-/ Dropdown ==> (AÇILIR MENÜ) /-/-//
    /*
     dropdown denince aklımıza --> select tagı gelecek
     1. Adım : Dropdown menüyü herhangi bir locator ile locate edin

     WebElement ddm = driver.findElement(By.xpath("......."))

     2. Adım : Yeni bir "SELECT" objesi oluşturun ve daha önce locate ettiğimiz WebElement'i parametre olarak
     yeni objeye ekleyin

     Select options = new Select(ddm)

     3. Adım : Select class'ından kullanabileceğimiz 3 yöntemden biriyle dropdown menüsündeki elemanlardan istediğinizi seçin

            1. Index kullanarak             ==> selectByIndex();
            2. Deger kullanarak             ==> selectByValue();
            3. Gorunen degerini kullanarak  ==> selectByVisibleText();

            Istenirse getOptions(); methodu kullanilarak DropDown’daki tum elementler webelementlerden olusan
                                    bir listeye konabilir.List<WebElement>

     */

    /*
    ●Bir class oluşturun:C3_DropDownAmazon
    ●https://www.amazon.com/ adresine gidin.
    -Test1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisini yazdirin
    4.Sonucun Java kelimesini icerdigini test edin
    */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w:drops) {
            System.out.println(w.getText());
        }
        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi,dropDownList);
    }
    @Test
    public void test2(){
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");

        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}