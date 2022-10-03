package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

public class A01_TestCase1 extends TestBaseBeforeAfter {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    //---------------------------------------------------------------------------//

    @Test
    public void test1() throws InterruptedException {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement logoWE = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoWE.isDisplayed());

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

        //6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("sampiyon");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("sampiyon@trabzon.com");
        Thread.sleep(2000);

        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("6161");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        select.selectByIndex(1);
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        select1.selectByVisibleText("January");
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        select2.selectByVisibleText("1967");
        Thread.sleep(2000);

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(2000);

        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);

        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        actions .sendKeys(Keys.TAB).sendKeys("En").sendKeys(Keys.TAB).sendKeys("Buyuk").sendKeys(Keys.TAB)
                .sendKeys("Trabzon").sendKeys(Keys.TAB).sendKeys("Spor")
                .sendKeys(Keys.TAB).sendKeys("Trabzon Spor A.S.").sendKeys(Keys.TAB).sendKeys("Trabzon").sendKeys(Keys.TAB)
                .sendKeys("Turkiye").sendKeys(Keys.TAB).perform();
        Select select3 = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        select3.selectByIndex(2);

        actions.sendKeys(Keys.TAB).sendKeys("---").sendKeys(Keys.TAB).sendKeys("---").sendKeys(Keys.TAB).sendKeys("---")
                .sendKeys(Keys.TAB).sendKeys("054616161").perform();
        Thread.sleep(2000);

        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam' düğmesini tıklayın
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
    }
}
