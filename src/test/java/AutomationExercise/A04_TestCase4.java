package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class A04_TestCase4 extends TestBaseBeforeAfter {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page


    @Test
    public void test4() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement signUpLinki = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLinki.click();

        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        WebElement loginYaziElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement emailAdresKutusu = driver.findElement(By.xpath("(//input[@name='email'])[1]"));
        emailAdresKutusu.sendKeys("sampiyon@trabzon.com");

        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@name='password']"));
        passwordKutusu.sendKeys("6161");

        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement loggedInYazisi = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(loggedInYazisi.getText());
        Assert.assertTrue(loggedInYazisi.isDisplayed());

        //9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

        //10. Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }
}
