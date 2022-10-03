package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class A02_TestCase2 extends TestBaseBeforeAfter {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible


    @Test
    public void test2() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement logoWE = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoWE.isDisplayed());

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("sampiyon@trabzon.com");
        actions.sendKeys(Keys.TAB).sendKeys("6161").perform();

        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("(//a)[11]")).isDisplayed());

        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        //10. 'HESAP SİLİNDİ!' görünür
    }
}
