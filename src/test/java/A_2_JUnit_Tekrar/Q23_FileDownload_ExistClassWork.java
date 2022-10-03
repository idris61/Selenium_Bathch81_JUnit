package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q23_FileDownload_ExistClassWork extends TestBaseBeforeAfter {

    @Test
    public void FileDownloadTest() throws InterruptedException {
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // 3. QA.jpg dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='QA.jpg']")).click();
        Thread.sleep(2000);

        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\idris\\Desktop\\Downloads\\QA.jpg\\";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // İndirildiğini konsolda gösterin
        System.out.println("Files.exists(Paths.get(dosyaYolu)) = " + Files.exists(Paths.get(dosyaYolu)));
    }
}
