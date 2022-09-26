package A_1_Maven_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_Maven_Soru1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3.Login alanine “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4.Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back(); // sayfa https olmadığı için güvenlik uyarısı veriyor. geri yapınca sayfaya dönüyor.

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        Thread.sleep(2000);

        //8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(2000);

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(2000);

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesajYazisi = driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (mesajYazisi.isDisplayed()) {
            System.out.println("Mesaj yazisi testi PASSED");
        } else {
            System.out.println("Mesaj yazisi testi FAILED");
        }

        driver.close();

    }
}
