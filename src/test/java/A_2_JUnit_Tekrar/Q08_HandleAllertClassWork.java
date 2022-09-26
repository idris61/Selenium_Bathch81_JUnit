package A_2_JUnit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q08_HandleAllertClassWork {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //● Bir class olusturun : Alerts
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver. get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void acceptAlertTest() {
    //● Bir metod olusturun : acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void dismissAlertTest() throws InterruptedException {
        //● Bir metod olusturun : dismissAlert
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(!driver.findElement(By.xpath("//p[@id='result']")).getText().contains("successfuly"));

    }

    @Test
    public void sendKeysAlertTest() {
        //● Bir metod olusturun:sendKeysAlert
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("idris");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "idris";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
