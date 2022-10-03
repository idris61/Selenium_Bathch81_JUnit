package A_2_JUnit_Tekrar;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q35_ReadExcelClassWork {
    @Test
    public void test() throws IOException {
        //Yeni bir test method olusturalim readExcel2()
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String row1cell2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("row1cell2 = " + row1cell2);

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualBaskent = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedBaskent = "Kabil";
        Assert.assertEquals(actualBaskent, expectedBaskent);

        //-Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satirSayisi = " + satirSayisi);

        //-Fiziki olarak kullanilan satir sayisini bulun
        int fizikiSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("fizikiSatirSayisi = " + fizikiSatirSayisi);

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String, String> ulkelerMap = new HashMap<>();

        for (int i = 0; i < satirSayisi; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkelerMap.put(key, value);
            System.out.println(key +" , "+ value);

        }

    }
}
