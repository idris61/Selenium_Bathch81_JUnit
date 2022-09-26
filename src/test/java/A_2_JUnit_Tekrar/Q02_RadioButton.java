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

public class Q02_RadioButton {

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
        driver.close();
    }

    @Test
    public void test() {
        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabuledin
        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement radioButtonKadin = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement radioButtonErkek = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement radioButtonOzel = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //-Secili degilse cinsiyet butonundan size uygun olani secin
        if (!radioButtonErkek.isSelected()) {
            radioButtonErkek.click();
        }

    }
}
