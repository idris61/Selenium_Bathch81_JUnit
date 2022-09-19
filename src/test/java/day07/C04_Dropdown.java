package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test1() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1); // please select an option'un index'i ==> 0 dır.
                                 // Option 1'in index'i ==> 1 dir.
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2"); // value ==> String 2 ("2")
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        // Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        // Tüm dropdown options'i yazdırın
        List<WebElement> tumOptionlar = select.getOptions();
        // getOptions() ile getirdiğimiz WebElement den oluşan bir list olduğu için direkt yazdıramayız.
        // ancak for each ile yazdırabiliriz.

        for (WebElement each : tumOptionlar) {
            System.out.println(each.getText());
        }

        // Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int dropdownBoyut = tumOptionlar.size();
        if (dropdownBoyut==4) {
            System.out.println("True");
        }else System.out.println("False");
    }

    /*
    NOT: Bir dropdown ile çalışıyorken, son seçilen option'a ulaşmak istersek
         select.getFirstSelectedOption() ==> methodunu kullanmalıyız.
         bu method bize WebElement döndürür.
         Üzerindeki yazıyı yazdırmak için getText() unutulmamalıdır.
     */
}