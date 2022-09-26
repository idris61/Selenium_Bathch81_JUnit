package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Q13_HandleWindowsClassWork {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void WindowHandleTest2() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String herokuappWH = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertEquals((driver.findElement(By.xpath("//h3")).getText()),("Opening a new window"));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(),("The Internet"));

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

        // NOT : YENİ BİR TAB'A GEÇTİĞİMİZ İÇİN DRIVER'I DA O SAYFAYA TAŞIMALIYIZ. YOKSA İŞLEM YAPAMAYIZ.!!!
        // switchTo() methodunu ve yeni tab'ın windowHandle değerini kullanacağız.
        /*
        Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
        atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
        ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
         */

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handle Değerleri = "+ windowList);
        driver.switchTo().window(windowList.get(1));

        /*  BU 2. YOL ==> MEHMET HOCANIN YÖNTEMİ;

        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Assert.assertEquals(driver.getTitle(),("New Window"));

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),("New Window"));

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(herokuappWH);
        Assert.assertEquals(driver.getTitle(),("The Internet"));

    }
}
