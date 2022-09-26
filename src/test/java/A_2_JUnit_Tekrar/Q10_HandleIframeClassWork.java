package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q10_HandleIframeClassWork {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void IframeTest() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //● Bir metod olusturun:iframeTest
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframe = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframe.isEnabled());
        System.out.println(iframe.getText());

        //○Text Box’a “Merhaba Dunya!”yazin.
        WebElement textBox = driver.findElement(By.id("mce_0_ifr"));// Frame'e geçiş yapmadan önce orayı locate ederiz
        driver.switchTo().frame(textBox); // Locate ettiğimiz frame geçmek için bu methodu kullanırız
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear();
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba Dunya!");
        /*
        textBox'ı doğru olarak locate etmemize rağmen driver bulamadı. Bunun üzerine HTML kodları inceleyince
        textBox'ın aslında bir IFrame içerisinde olduğunu gördük
        Bu durumda önce IFrame'i locate edip  switchTo() ile o IFrame geçmeliyiz.
         */

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elemental = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());

        /*
        link yazi elementini doğru locate etmemize rağmen yazdırmadı. Çünkü yukarıda IFrame e geçiş yapmıştık.
        önce IFrame den çıkmamız lazım.
        Iframe’den cikmak icin 2 komut vardir;
        driver.switchTo().parentFrame();      ==> 1 ust seviyedeki frame’e cikartir
        driver.switchTo().defaultContent();   ==> En ustteki frame’e cikmak icin kullanilir
         */
    }
}
