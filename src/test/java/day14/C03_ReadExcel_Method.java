package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel_Method {
    @Test
    public void readExcelTest1() throws IOException {

    // belirtilen satir no ve sutun no degerlerini parametre olarak alip
    // o cell'deki datayi String olarak bana döndüren bir method oluşturun

        int satir = 12;
        int sutun = 2;

    // dönen String'in Baku olduğunu test edin

        String expectedData = "Baku";

        String actualData = banaDataGetir(satir-1,sutun-1);
        Assert.assertEquals(expectedData,actualData);



    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String isteneData ="";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        isteneData = workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return isteneData;
    }
}
