package tests.f15_cnfigiration_driver_Kullanimi;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class F01_WebuniversityTesti {

    @Test
    public void negatifLoginTesti(){
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalLinki);
        //3."Login Portal" a tiklayin
        ReusableMethods.bekle(1);
        webuniversityPage.loginPortalLinki.click();
        //4.Diger window'a gecin
        ReusableMethods.titleIleSayfaDegistir("WebDriver | Login Portal");
        //5."username" ve  "password" kutularina rastgele deger yazdirin
Faker faker = new Faker();
webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6."login" butonuna basin
       webuniversityPage.loginPortalLinki.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
       String expectedAlertYazi = "validation failed";
       String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazi);
        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        String ilkSayfa = "Web";
        //10.Ilk sayfaya donuldugunu test edin

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}