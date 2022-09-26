package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q12_HandleWindowsClassWork {
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
    public void WindowHandleTest() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitleamazon = driver.getTitle();
        Assert.assertTrue(actualTitleamazon.contains("Amazon"));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String walmartWindowHandle = driver.getWindowHandle();

        //● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitleamazon));

    }
}
