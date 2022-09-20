package day10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaceClass extends TestBaseBeforeAfter {

    /*
    ** utilities package'ında abstract class oluşturduk. Buradaki class'ı Utilites package'ındaki
    ** class'a extent yaptik.@Before ve @After methodlarını oradaki class'ta olusturdugumuz icin bu sayfada olusturmamıza
       gerek kalmadı
     */


    @Test
    public void test1(){
        driver.get("https://amazon.com");

    }
}
