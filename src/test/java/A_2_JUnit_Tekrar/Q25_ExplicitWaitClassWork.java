package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class Q25_ExplicitWaitClassWork extends TestBaseBeforeAfter {

    // 2.Iki tane metod olusturun : implicitWait() ,explicitWait()
    // Iki metod icin de asagidaki adimlari testedin.
    @Test
    public void implicitWaitTest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4.Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

        // 6.Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 7.It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitWaitTest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4.Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5.“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait objesi oluşturduk
        WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));// görünür olmasını istediğimiz elementi locate ettik
        wait.until(ExpectedConditions.visibilityOf(itsGone)); //it's gone! WE nin görünür olmasını bekle dedik
        Assert.assertTrue(itsGone.isDisplayed()); // sonra görünür olduğunu test et dedik

        // 6.Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 7.It’s back mesajinin gorundugunu test edin
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}
