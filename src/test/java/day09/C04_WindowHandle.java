package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C04_WindowHandle {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu bir ArrayList'e
        atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
        ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
         */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Window Handle Değerleri = "+ windowList);
        driver.switchTo().window(windowList.get(1));

        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());

    }
}
    /*
                    ÖNCEKİ DERSTEN AKLIMIZDA KALANLAR
     1- Window handling : Bazen bir otomasyonda, içinde olduğumuz sayfadan başka bir sekme veya başka bir window'a
        yönlendirilebiliriz.
     2- Eğer kontrollü olarak yeni sayfaya geçiyorsak

        driver.switchTo().newWindow(window type) diyerek yeni bir sekme veya yeni bir pencere açarsak, driver otomatik
        olarak yeni sayfaya geçecektir.

        Eğer test case'imizde yeniden ilk sayfaya dönme görevi varsa, ikinci sayfaya geçmeden önce ilk sayfanın
        window handle değerini alıp bir String variable'a assign ederiz.

        Böylece iğstediğimiz anda bu handle değerini kullanarak ilk sayfaya dönebiliriz.

     3- Eğer yeni sayfa açılması tıkladığımız bir link ile oluyorsa, driver yeni sayfaya GECMEZ, bu durumda ilk sayfa
        ve ikinci sayfanın window handle değerlerini bulup, bu handle değerleri ile sayfalar arasında geçiş yapmamız gerekir.

        - ilk olarak ilk sayfada iken window handle değerini alıp String bir variable'a assign ederiz
        - linki tıkladıktan sonra ikinci sayfa da açılacaktır. İkinci sayfa açıldıktan sonra
          driver.getWindowHandles() methodu'unu kullanarak her iki sayfanın window handle değerini alıp bir Set'e koyarız.
        - Set içindeki iki window handle değerinden biri ilk sayfanın window handle değeridir, ilk sayfanın window handle
          değerine eşit olmayan ise ikinci sayfanın window handle değeridir.

        Bu şekilde iki sayfanın window handle değerini belirleyip, istediğimiz gibi geçiş yapabiliriz.
     */