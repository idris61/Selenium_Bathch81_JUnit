package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;
                // METHOD KISMI TEKRAR ÇALIŞILACAK!!!!!!
public class Q34_0_WebTablesClassWork_TEKRARBAKILACAK extends TestBaseBeforeAfter {

    //Bir metod oluşturun : printData(int row, int column);
    //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
    //hücredeki(cell) veriyi yazdırmalıdır.
    //Baska bir Test metodu oluşturun: printDataTest( );
    //Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
    //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    //yazdirilan datanin olmasi gereken dataya esit oldugunu test edin

    @Test
    public void printDataTest() {

        // https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //Username : manager
        //Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        int row = 3;
        int column = 7;

        Object expectedData = "Queen";
        Object data = printData(row, column);
        System.out.println(data);
        Assert.assertEquals(expectedData, data);
    }
    private Object printData(int row, int column) {
        WebElement dataWE = driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        Object data = dataWE.getText();
        return data;
    }
}
