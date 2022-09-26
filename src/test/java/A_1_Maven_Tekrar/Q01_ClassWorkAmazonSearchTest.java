package A_1_Maven_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Q01_ClassWorkAmazonSearchTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1-https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

        //2-arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        //3-“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4-Bulunan sonuc sayisini yazdiralim
        String [] sonucYazisi = driver.findElement
                (By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .getText()
                .split(" ");
        System.out.println(Arrays.toString(sonucYazisi)); // [1-16, of, 255, results, for, "Samsung, headphones"]
        System.out.println((sonucYazisi)[2]); // 255

        //5-Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //6-Sayfadaki tum basliklari yazdiralim
        WebElement basliklar = driver.findElement(By.xpath("//span[@id='productTitle']"));

        System.out.println(basliklar.getText());

        driver.close();


    }
}
