package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void test1() throws IOException {

        // Yeni bir Class olusturalim WriteExcel
        // Yeni bir test method olusturalim writeExcelTest()
        // Adimlari takip ederek 1.satira kadar gidelim
        String dosyaYolu = "src/resources/ulkeler.xlsx"; // Bilgisayardaki bir dosyaya ulaşmak için selenium'a değil java'ya ihtiyaç vardı.
                                                         // javanın da dosyaya ulaşabilmesi için dosya yoluna ihtiyacı vardı.
        FileInputStream fis = new FileInputStream(dosyaYolu); // dosyayı okuyabilmemiz için FileInputStream oluşturmamız gerekiyordu.
                                                              // girmiş olduğumuz dosya yolundaki dosyayı bul ve o dosyayı oku
        Workbook workbook = WorkbookFactory.create(fis); // excell'i okuduk. kullanabilmemiz için içinde bulunduğumuz class'a getirmemiz lazım
                                                         // bunun için workbook oluşturmamız gerekiyor. ve fis'i girmemiz gerekiyor

        // 5.hucreye yeni bir cell olusturalim. Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook
                .getSheet("Sayfa1")  // workbook'dan başlayıp Sayfa1'e git,
                .getRow(0)           // sayfada 0. row'a (çünkü indexler 0 dan başlıyor),
                .createCell(4)       // 4. indexte yeni bir cell oluştur
                .setCellValue("Nufus");// cell'e "Nufus" değerini ata

        // 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");

        // 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");

        // 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");

        // Dosyayi kaydedelim

        //*** Şuana kadar yaptığımız değişiklikleri workbook'ta benim classımda yaptık, excell'de herhangi bir değişiklik olmadı
        //*** workbook'u excell'e yollamalıyız. --> FileOutputStream
        FileOutputStream fos = new FileOutputStream(dosyaYolu);

        // Excel dosyamıza veri girişi yaptıktan sonra dosyayı akışa aldığımız gibi sonlandırmamız gerekir.
        // Sonrasında da workbook objemize kayıt etmemiz gerekir
        workbook.write(fos); // Write methodu ile sonlandırdığımız işlemi workbook'a yazdırdık

        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}