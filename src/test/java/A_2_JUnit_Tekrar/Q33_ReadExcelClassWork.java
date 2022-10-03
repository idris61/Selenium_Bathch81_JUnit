package A_2_JUnit_Tekrar;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Q33_ReadExcelClassWork {
    @Test
    public void test() throws IOException {
        // 2. Java klasoru altinda resources klasoru olusturalim
        // 3. Excel dosyamizi resources klasorune ekleyelim
        // 4. excelAutomation isminde bir package olusturalim
        // 5. ReadExcel isminde bir class olusturalim
        // 6. readExcel() method olusturalim
        readExcel();


    }

    private void readExcel() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // 11. Worksheet objesi olusturun workbook.getSheetAt(index)
        // 12. Row objesi olusturunsheet.getRow(index)
        // 13. Cell objesi olusturunrow.getCell(index)
        String actualData = workbook.
                                    getSheet("Sayfa1")
                                    .getRow(3)
                                    .getCell(3)
                                    .toString();
        System.out.println(actualData);
    }
}
