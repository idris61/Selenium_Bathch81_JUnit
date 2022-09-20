package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1) https://www.gmibank.com/ adresine gidin
        driver.get("https://www.gmibank.com/");

        // 2) sign in butonuna tıkla
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();

        // 3) Username : Batch81, Password : Batch81+
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Batch81+", Keys.ENTER);

        // driver.findElement(By.cssSelector("#username")).sendKeys("Batch81");
        // driver.findElement(By.cssSelector("#password")).sendKeys("Batch81+", Keys.ENTER);
        // driver.findElement(By.xpath("(//*[text()='Sign in'])[4]")).click();

    }
}
