package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q22_GenelTekrarTesti extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //1-amazon gidin
        driver.get("https://www.amazon.com/");

        //2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownWE = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownWE);

        List<WebElement> dropDownList = select.getOptions();
        for (WebElement element : dropDownList) {
            System.out.println(element.getText());
        }
        System.out.println(dropDownList.size());

        //3-dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertNotEquals(dropDownList.size() , 40);
    }

    @Test
    public void test2() {

        driver.get("https://www.amazon.com");

        // 1- dropdown menuden elektronik bölümü seçin
        WebElement dropDownWE = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownWE);
        select.selectByVisibleText("Electronics");

        // 2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);

        String [] iphoneSonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                                      .getText().split(" ");
        System.out.println("iphone Sonuc Yazisi = " + Arrays.toString(iphoneSonucYazisi));
        System.out.println("iphone Sonuc Sayisi : " + iphoneSonucYazisi[3]);

        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement iphoneSonucYazisi2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(iphoneSonucYazisi2.getText().contains("iphone"));

        // 4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[1]"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4'])[3]"));

        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(birinciUrun).toLeftOf(ucuncuUrun));
        ikinciUrun.click();

        // 5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    }

    @Test
    public void test3() {

        // 1- yeni bir sekme açarak amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- dropdown’dan bebek bölümüne secin
        WebElement dropDownWE = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownWE);
        select.selectByVisibleText("Baby");

        // 3- bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bebek puset"+ Keys.ENTER);

        // 4- sonuç yazsının puset içerdiğini test edin

        // 5- üçüncü ürüne relative locater kullanarak tıklayin

        // 6- title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    }

    @Test
    public void test4() {

        // 1- sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}


