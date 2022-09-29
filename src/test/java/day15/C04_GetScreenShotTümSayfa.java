package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShotTümSayfa extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim tum sayfanın resmini alalim
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResmi);

        //*** Her yeni ekran görüntüsü aldığımızda bir öncekini silmemesi için, kodumuzun da dinamik olması için
        //*** görüntü ismine LokalDateTime methodunu kullanarak "tarih" kısmını ekledik.
        //*** böylelikle, ekran görüntüsü aldığımızda o anki tarih ve saati görüntü ismine ekliyor.


        /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */
      //  TakesScreenshot ts = (TakesScreenshot) driver;
      //  File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
      //  FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
    }
}