package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class A08_TestCase8 extends TestBaseBeforeAfter {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. The products list is visible
    //7. Click on 'View Product' of first product
    //8. User is landed to product detail page
    //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    @Test
    public void test8() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement logoElementi= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //4. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[text()=' Products'] ")).click();

        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        String expectedUrl="https://automationexercise.com/products";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //6. Ürün listesi görünür

        //7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın


        //8. Kullanıcı, ürün detay sayfasına yönlendirilir
        //9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
    }
}
