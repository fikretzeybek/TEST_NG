package tests.f14_testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class F04_DriverClassKullanimi {

    @Test
    public void test01() throws InterruptedException {
          /*
      POM de 4 farkli dosyadan ihtiyacimiz olan bilgileri aliriz
      1- Driver class == driver
      2- pages package altindaki page class'lari == locate
      3- configurtaion.properties dosyasi == test datalari
      4- Reusable methods class == ihtiyac duyabilecegimiz pratik method'lar

      Daha once kullandigimiz extends keyword ile inheritance sadece 1 class'a olabileceginden
      POM'de tercih edilmemistir

      Java'da bir class'daki class uyelerini kullanmanin farkli yollari vardir

      1- extends ile inherit edip direk kullanma
      2- class uyelerini static tanimlayip classAdi.uyeAdi seklinde kullanabiliriz
      3- istedigimiz class'dan obje olusturarak class uyelerini kullanabiliriz

      POM 2 yontemi de kullanir.
     */

        /*
            POM hazirlayanlar
            WebDriver objesini Testbase'den almak yerine, extends keyword'une ihtiyac duymadan
            kullanabilecegimiz, static bir method'da olusturmayi tercih etmistir
         */

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // arama kutusuna phone yazip aratalim

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonuclarini yazdirin

        WebElement aramaSonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(aramaSonucElementi.getText());

        Thread.sleep(5000);

        Driver.closeDriver();
    }
}