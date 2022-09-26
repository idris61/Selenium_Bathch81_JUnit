package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_youtubeAssertions {

    static  WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
        //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void test1() {
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals(driver.getTitle(), "YouTube");

    }
    @Test
    public void test2() {
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeResmi = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeResmi.isDisplayed());
    }
    @Test
    public void test3() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());

    }
}
