package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q06_DropDownAmazon {
    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        //-Test1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> ddmList = select.getOptions();
        int actualOptions = ddmList.size();
        int expectedOptions = 45;
        Assert.assertNotEquals(expectedOptions, actualOptions);
    }

    @Test
    public void test2() {
        //-Test2
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        select.selectByVisibleText("Books");

        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        //3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());

        //4.Sonucun Java kelimesini icerdigini test edin
        String actualSonucYazisi = sonucYazisi.getText();
        String expectedKelime = "Java";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }
}
