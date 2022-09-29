package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;
import java.util.Set;
public class C01_Cookie extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // 2-tum cookie’leri listeleyin
        Set<Cookie> tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);
        int sayac = 1;

        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = tumCookie.size();
        Assert.assertTrue(cookieSayisi>5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookie) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookie = driver.manage().getCookies();
        sayac = 1;

        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }

        // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.contains(yeniCookie));

        // 7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie = driver.manage().getCookies();
        sayac = 1;

        for (Cookie w:tumCookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Assert.assertFalse(tumCookie.contains("skin"));

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie = driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());
    }
}
    /*          /-/-/ Cookies /-/-/
    Çerezler, belirli kullanıcıları tanımlamak ve bu kullanıcıların göz atma deneyimini iyileştirmek için kullanıcının
    bilgisayarı ile web sunucusu arasında takas edilen, kullanıcı adı ve parola gibi küçük veri parçalarını
    içeren dosyalardır.
    İnternette gezinirken ziyaret ettiğiniz web sayfaları, bilgisayarınıza ve telefonunuza küçük bilgi dosyaları kaydeder.
    Bu dosyalar telefon veya bilgisayarınızın hafızasında saklanır. Daha sonra aynı siteleri ziyaret ettiğinizde
    bu kayıtlı bilgi dosyaları sayesinde siteler sizi tanıyabilir.

    Selenium ile cookies otomasyonu yapabiliriz.
        Driver.manage( ). method’u ile cookie’leri
        - listeleyebilir
        - Isim ile cagirabilir
        - Yeni cookie ekleyebilir
        - Var olanlari ismi silebilir
        - Var olan tum cookie’leri silebiliriz
     */
    /*
                ÖNCEKİ DERSTEN AKLIMIZDA KALANLAR
     1- Selenium waits (senkronizasyon) : Kodlarımızla, internet ve bilgisayarın çalışmasını uyumlu hale getirmek için
        bazen kodlarımızı bekletmemiz gerekir.

     2- Seleniumda kullandığımız 3 çeşit wait vardır.

        1- Thread.sleep() : Java'dan gelir ve kodları durdurur. Kendisine verilen sürenin TAMAMINI bekler.
           Dinamik değil Statiktir.

        2- imlicitlyWait : Selenium'dan gelir. Sayfanın yüklenmesi ve herbir webElementin locate edilmesi için beklenecek
           maximum süreyi belirler. Esnektir. Esas olan beklemek değil, kodun çalışmasını sağlamaktır. Kod çalışırsa
           beklemeden devam eder, kod çalışmazsa maximum süre doluncaya kadar bekler ve sonra hata mesajı verir.
           Elementi bulamazsa nosuchElementException, sayfayı yükleyemezse sayfa yükleme hatası verir.

        3- ExplicitlyWait : Selenium'dan gelir, spesifik bir işlem için beklenecek maximum süreyi belirler.
           ExplicitlyWait kullanabilmek için wait objesi oluşturmamız gerekir.
           wait.until(ExpectedConditions.... istediğimiz fonk.) şeklinde kullanılabilir.
           Genellikle wait.until() method'u locate ile birlikte kullanılır.
     */