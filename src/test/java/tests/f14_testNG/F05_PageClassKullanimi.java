package tests.f14_testNG;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class F05_PageClassKullanimi {

     /*
       Pages class'lari bir websayfasinda locate etmek istedigimiz
       webElementleri locate edip, sonrasinda ihtiyacimiz oldukca kullanmak icin olusturulur

       pages class'larinda locate edilen webElement'lere erisebilmek icin
       test class'imizda ilgili page class'indan bir obje olustururuz
     */


    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(3);
        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(3);

        // bulunan sonuc sayisinin 1'den cok oldugunu test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>1);

        // arama sonuc sayisini yazdirin
        System.out.println(testOtomasyonuPage.sonucYaziElementi.getText());
        // sayfayi kapatin
        Driver.closeDriver();
    }
}