package tests.f15_cnfigiration_driver_Kullanimi;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class F02_ConfigurationPropertiesKullanimi {

     /*
        POM'de hedef test class'inda
        manuel olarak hic bir Test Data'si GIRMEMEKTIR

        Test datalari :
        1- Kullanacagimiz WebDriver : Driver class'indan dinamik olarak kullaniyoruz
        2- Locate : Locate'leri pages sayfalarindan dinamik olarak kullaniyoruz
        3- kullanilan Url, aranan kelime, expected icerik, dogru kullanici adi,
           yanlis kullanici adi, yanlis sifre... gibi datalar
     */

    @Test
    public void aramaTesti() {

        // test otomasyonu anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // configuration.properties'de belirlenmis olan aranacak urunu aratin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        // arama sonucunda urun bulunabildigini test edin

        int bulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(bulunanUrunSayisi > 0);

        // ilk urune tiklayin

        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

        // acilan sayfada urun isminin case sensitive olmadan
        // configuration.properties'de belirlenmis olan aranacak kelimeyi icerdigini test edin

        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                .urunSayfasindakiUrunIsimElementi
                .getText()
                .toLowerCase();
        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}