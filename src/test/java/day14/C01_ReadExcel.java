package day14;

import org.apache.poi.ss.usermodel.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class  C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu= "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // oluşturmuş olduğumuz dosyayı sistemde işleme alır.

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);  // Workbook objesiyle, fis objesi ile akışa aldığımız dosyamızla
                                                          // bir excell dosyası creat ettik

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excel dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa1 deki 3. satırı bu şekilde seçeriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır.
        System.out.println(cell);

        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData, actualData);

    }
}
    /*
    Ara --> dosyaYolu
    Windows Gezgini ile ac --> FileInputStream
    Excel i ac --> Workbook
    Sayfa1 e git --> Sheet
    Satiri bul --> Row
     */
    /*
                    Excel’inYapisi
    ➢Excel icin daha once inceledigimiz Web Table yapisina benzer bir yapi vardir.
    ➢Excel’de bir hucredeki bilgiye ulasmak icin
        dosya/sayfa/satir/sutun sirasiylailerlemeliyiz

    ➢Excel ile ilgili otomasyonda webtable’da oldugu gibi sutun yapisiy oktur, ihtiyac duyarsak kodla sutunu elde
    edebiliriz ancak bir dataya ulasmak icin sutun kullanamayiz
        Workbook    ==> excel dosyamiz
        Sheet       ==> Her açık excel sekmesi (Sheet1, Sheet2,etc)
        Row (satir) ==> Java, yalnızca içeride veri varsa satırları sayar.
        Default olarak, Java perspektifinden satır sayısı 0'dır
        Cells (hucre) ==> Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar.
     */