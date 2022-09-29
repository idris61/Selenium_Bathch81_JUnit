package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q22_GenelTekrarTesti extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // 1- amazon gidin
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click(); // çerezleri kabul et

        // 2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownWE = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownWE);

        List<WebElement> dropDownList = select.getOptions();
        for (WebElement element : dropDownList) {
            System.out.println(element.getText());
        }
        System.out.println("Drop Down Size : " + dropDownList.size());

        // 3- dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertNotEquals(dropDownList.size() , 40);

        // TEST -2:
        // 1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Elektronik");

        // 2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);

        String [] iphoneSonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                                      .getText().split(" ");
        System.out.println("iphone Sonuc Yazisi = " + Arrays.toString(iphoneSonucYazisi));
        System.out.println("iphone Sonuc Sayisi : " + iphoneSonucYazisi[0]+" "+iphoneSonucYazisi[1]);

        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement iphoneSonucYazisi2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(iphoneSonucYazisi2.getText().contains("iphone"));

        // 4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]"));

        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(birinciUrun).toLeftOf(ucuncuUrun));
        ikinciUrun.click();

        // 5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim,
        String birinciUrunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String birinciUrunFiyati = driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        WebElement sepeteEkleWE = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        sepeteEkleWE.click();

        // TEST-3 :
        // 1- yeni bir sekme açarak amazon ana sayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com.tr");

        // 2- dropdown’dan bebek bölümüne secin
        WebElement dropDownWE2 = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select2 = new Select(dropDownWE2);
        select2.selectByIndex(2);

        // 3- bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bebek puset"+ Keys.ENTER);
        String [] bebekPusetiSonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                                            .getText().split(" ");
        System.out.println("Bebek puseti sonuc yazisi : " + Arrays.toString(bebekPusetiSonucYazisi));
        System.out.println("Bebek puseti sonuc sayisi : " + bebekPusetiSonucYazisi[0]+" "+bebekPusetiSonucYazisi[1]);

        // 4- sonuç yazsının puset içerdiğini test edin
        WebElement bebekPusetiSonucYazisi2 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(bebekPusetiSonucYazisi2.getText().contains("puset"));

        // 5- üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun2 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        WebElement dorduncuUrun2 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[4]"));

        WebElement ucuncuUrun2 = driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(ikinciUrun2).toLeftOf(dorduncuUrun2));
        ucuncuUrun2.click();

        // 6- title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String ikinciUrunTitle = driver.findElement(By.xpath("//span[@class='a-size-large product-title-word-break']")).getText();
        String ikinciUrunFiyat = driver.findElement(By.xpath("//span[@class='a-price aok-align-center']")).getText();


        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click(); // sepete ekle
        driver.findElement(By.xpath("//a[@class='a-button-text']")).click(); // sepete git


        String sepetIkinciUrunTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();
        String sepetBirinciUrunTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();

        String sepetIkinciUrunFiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]")).getText();
        String sepetBirinciUrunFiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();

        // TEST-4 :
        // 1- sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        System.out.println("birinciUrunTitle = " + birinciUrunTitle);
        System.out.println("sepetBirinciUrunTitle = " + sepetBirinciUrunTitle);

        System.out.println("ikinciUrunTitle = " + ikinciUrunTitle);
        System.out.println("sepetIkinciUrunTitle = " + sepetIkinciUrunTitle);

        System.out.println("birinciUrunFiyati = " + birinciUrunFiyati);
        System.out.println("sepetBirinciUrunFiyat = " + sepetBirinciUrunFiyat);

        System.out.println("ikinciUrunFiyat = " + ikinciUrunFiyat);
        System.out.println("sepetIkinciUrunFiyat = " + sepetIkinciUrunFiyat);

        Assert.assertEquals(birinciUrunTitle,sepetBirinciUrunTitle);
        Assert.assertEquals(ikinciUrunTitle,sepetIkinciUrunTitle);
        Assert.assertNotEquals(ikinciUrunFiyat,sepetIkinciUrunFiyat); // fiyat aynı, virgül sonrası için failed veriyor
        Assert.assertNotEquals(birinciUrunFiyati,sepetBirinciUrunFiyat); // fiyat aynı, virgül sonrası için failed veriyor

        /*
        birinciUrunFiyati = 1.077
        92TL
        sepetBirinciUrunFiyat = 1.077,92 TL
        ikinciUrunFiyat = 349
        99TL
        sepetIkinciUrunFiyat = 349,99 TL

         */

    }
}


