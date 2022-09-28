package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test1() {

        System.out.println(System.getProperty("user.dir"));//C:\SeleniumBatch81\com.Batch81JUnit
        // Şuanki içinde bulunduğum projenin dosya yolunu (path) gösterir

        System.out.println(System.getProperty("user.home"));//C:\Users\idris ==> benim bilgisayarımın özel kısmını verir.

        // masaüstündeki text dosyasının varlığını test edin
        // "C:\Users\idris\Desktop\text.txt"  // masa üstündeki dosyanın yolu (home path)
        String dosyaYolu = System.getProperty("user.home")+"Desktop\\text.txt";
        System.out.println(dosyaYolu); // C:\Users\idrisDesktop\text.txt

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan  masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin;
         */

        String farkliKisim= System.getProperty("user.home");

        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\text.txt";

        // mac icin   "/Desktop/text"

        String masaustuDosyaYolu = farkliKisim + ortakKisim ;
        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu))); // true
                                        // masaüstünde  text.txt dosyası olduğunu doğruladı.

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu))); // dosyanın var olduğunu assert ile test edelim

        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */




    }
}