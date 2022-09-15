package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;
    @Before              // Before notasyonu her testten önce çalışır.
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1(){
        // 1 defa Before methodu çalışır
        driver.get("https://www.amazon.com");
        // 1 defa After methodu çalışır
    }

    @Test
    public void method2(){
        // 1 defa Before methodu çalışır
        driver.get("https://techproeducation.com");
        // 1 defa After methodu çalışır
    }

    @Test
    public void method3(){
        // 1 defa Before methodu çalışır
        driver.get("https://hepsiburada.com");
        // 1 defa After methodu çalışır
    }


    @After              // After notasyonu her testten sonra çalışır.
    public void tearDown(){
        driver.close();
    }

}