package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class Q30_CookiesClassWork extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // 1- Amazon anasayfayag idin
        driver.get("https://amazon.com");

        // 2- tum cookie’leri listeleyin
        Set<Cookie> tumCookies = driver.manage().getCookies();
        System.out.println("tumCookies = " + tumCookies);

        int sayac = 1;

        for (Cookie w:tumCookies) {
            System.out.println(sayac + " . cookie : " + w);
            System.out.println(sayac + " . name : " + w.getName());
            System.out.println(sayac + " . value : " + w.getValue());
            sayac++;
        }

        // 3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = tumCookies.size();
        Assert.assertTrue(cookieSayisi>5);

        // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCookies){
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD", w.getValue());
            }
        }

        // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCookies = driver.manage().getCookies();

        sayac = 1;

        for (Cookie w:tumCookies) {
            System.out.println(sayac + " . cookie : " + w);
            System.out.println(sayac + " . name : " + w.getName());
            System.out.println(sayac + " . value : " + w.getValue());
            sayac++;
        }

        // 6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookies.contains(yeniCookie));

        // 7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookies = driver.manage().getCookies();
        sayac = 1;

        for (Cookie w:tumCookies) {
            System.out.println(sayac + " . cookie : " + w);
            System.out.println(sayac + " . name : " + w.getName());
            System.out.println(sayac + " . value : " + w.getValue());
            sayac++;
        }
        Assert.assertFalse(tumCookies.contains("skin"));

        // 8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookies = driver.manage().getCookies();
        Assert.assertTrue(tumCookies.isEmpty());
    }
}
