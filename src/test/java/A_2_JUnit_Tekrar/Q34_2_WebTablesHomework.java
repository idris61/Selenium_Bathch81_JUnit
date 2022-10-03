package A_2_JUnit_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Q34_2_WebTablesHomework extends TestBaseBeforeAfter {
    @Test
    public void test1() {
    //Bir Class olusturun D19_WebtablesHomework
    //"https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");

    //Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentList = new ArrayList<>(driver.findElements(By.xpath("//div[@role='gridcell'][6]")));
        departmentList.forEach(t -> System.out.println("Department : " + t.getText()));

    //sutunun basligini yazdirin
        System.out.println("-----------------------Tablo Title-----------------------");
        WebElement baslik = driver.findElement(By.xpath("//div[@class='rt-tr']"));
        System.out.println("Tablo Title : " + baslik.getText());
        System.out.println("-----------------------Tablo Title-----------------------");

    //Tablodaki tum datalari yazdirin
        System.out.println("-------------------------TUM TABLO--------------------------");
        WebElement tumTablo = driver.findElement(By.xpath("//div[@class='ReactTable -striped -highlight']"));
        System.out.println(tumTablo.getText());
        System.out.println("-------------------------TUM TABLO--------------------------");

    //Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tumCell = new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-td']")));
        System.out.println("Tüm Cell sayisi " + tumCell.size());

    //Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = new ArrayList<>(driver.findElements(By.xpath("//div[@role='row']")));
        System.out.println("Toplam Satır Sayısı : " + satirSayisi.size());

    //Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunlar = new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']")));
        System.out.println("Sutun Sayısı : " + sutunlar.size());

    //Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuColumn = new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-td' or role='gridcell'][3]")));
        ucuncuColumn.forEach(t -> System.out.println("3. kolon : " + t.getText()));

    //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> firstNameList = driver.findElements(By.xpath("//div[@class='rt-td' or role='gridcell'][1]"));

        for (int i = 0; i < firstNameList.size(); i++) {
            if (firstNameList.get(i).getText().equals("Kierra")) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][5])[" + (i + 1) + "]")).getText());
            }
        }

    //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
        data(2, 3);
    }

    private void data(int x, int y) {
        WebElement veri = driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][" + x + "])[" + y + "]"));
        System.out.println("İstenilen Veri :" + veri.getText());
    }
}