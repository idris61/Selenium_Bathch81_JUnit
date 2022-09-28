package A_2_JUnit_Tekrar;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Q19_Faker extends TestBaseBeforeAfter {
    @Test
    public void FakerTest() {

        //1."https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2.“create new account” butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3.“firstName” giris kutusuna bir isim yazin
       /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("((//*[@class='inputtext _58mg _5dba _2ph-'])[1])"));
        Actions actions = new Actions(driver);
        String email = faker.internet().emailAddress(); // aynı mail adresini girmesi için String bir değişkene atadık.

        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).sendKeys("Oca").sendKeys(Keys.TAB).sendKeys("1986").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
