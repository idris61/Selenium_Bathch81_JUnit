package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q11_HandleIframeClassWork {
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
        driver.quit();

    }

    @Test
    public void IframeTest() throws InterruptedException {

        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeSayisi);
        System.out.println("iframe sayisi = "+iframeSayisi.size());

        //ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iframeSayisi.get(0));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        Thread.sleep(2000);

        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız
        Thread.sleep(2000);
        driver.switchTo().frame(iframeSayisi.get(1));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
        Thread.sleep(2000);
    }
}
