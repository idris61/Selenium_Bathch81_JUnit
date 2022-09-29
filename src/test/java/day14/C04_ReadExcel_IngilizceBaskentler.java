package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel_IngilizceBaskentler {
    @Test
    public void readEcxelTest1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //-Ingilizce baskentler sutununu yazdiralim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
                    // getLastRowNum() methodu bize excel sayfasındaki son satır indexini getiriyor.
        System.out.println("Satir sayisi : " + sonSatir); // 190

        String IngilizceeBaskentler = "";

        for (int i = 0; i <= sonSatir; i++) {
            IngilizceeBaskentler = C03_ReadExcel_Method.banaDataGetir(i,1);
            System.out.println(IngilizceeBaskentler);
        }
    }
}
