package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){

     /*      /-/-/  Actions Class  /-/-/

    ➢ TestNg’de Actions class’ini kullanarak mouse ve klavye ile yapabilecegimiz tum islevleri gerceklestirebiliriz.
    ➢ Actions Class birçok kullanışlı mouse ve klavye işlevine sahiptir.
    ➢ Çift tıklama (double click), sürükleme ve bırakma(drag and drop), mouse’u hareket ettirme (mouse actions) gibi
       karmaşık mouse eylemleri icin veya Keyboard ile yapabilecegimiz pageUp, pageDown, shift, arrowDown gibi
       islemleri Actions classindan object ureterek driver ile yapabiliriz.

    ➢ 1.Adım: Actions class’ta bir object oluşturulur.
            Actions actions= newActions(driver);
    ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesi bulunur.
            WebElement element =driver.findElement(By.id("ID"));
    ➢ 3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir. Örneğin tıklamak için.
            actions.click(element).perform();

    NOT : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
    action objesi’ni bir kere olusturunca, istediginiz kadar action. ile baslayan komut yazar ve calismasi
    icin sonuna perform( )yazariz.
    action objesi kullanilarak baslayan her komut, calismak icin perform() bekler.
     */
        /*
                Mouse BaseActions MouseAksiyonlari

        ➢ doubleClick ()    : WebElement’e çift tıklama yapar
        ➢ clickAndHold ()   : WebElement uzerinde click yapili olarak bizden komut bekler.
        ➢ dragAndDrop ()    : WebElement’i bir noktadan diğerine sürükler ve bırakır
        ➢ moveToElement ()  : Mouse’u istedigimiz WebElement’in uzerinde tutar
        ➢ contextClick ()   : Mouse ile istedigimiz WebElement’e sag tiklama yapar.
         */

        // Amazon sayfasına gidelim
        // Account menüsünden create a list linkine tıklayalım
        driver.get("https://amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver);

        // actions.moveToElement(accountList).perform();
       // driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
