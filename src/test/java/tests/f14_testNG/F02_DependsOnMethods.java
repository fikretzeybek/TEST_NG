package tests.f14_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class F02_DependsOnMethods {

    /*
        dependsOnMethods oncelik sirasina karismaz

        Eger sirasi gelen bir test dependsOnMethods ile baska bir method'a bagli ise
        once bagli olunan testin calisip, pass olmasini kontrol eder

        bagli olunan test calismazsa veya calisir ama FAILED olursa
        bu durumda bagli olan test method'u calismaz, ignore olarak isaretlenir

        Normalde her bir test method'u bagimsiz olarak calistirilabilir
        Ancak dependsOnMethods ile bagli olan iki method'dan
        bagli olan run edilirse, oncelikle bagli olunan test method'unun calismasini saglar
        bagli olunan method calisip PASSED olursa, bagli olan kendisi de calisir

     */
 /*
      iki test method'u dependsOnMethods ile birbirine baglandiysa

      sadece baglanan method'u calistirmak isterseniz,
      dependsOnmethods ozelligi tanimli oldugundan once
      bagli olunan method'u calistirir,
      o test passed olursa bagli olan test'i de calistirir.

      Ancak bagli olan testler ikiden fazla ise
      2.testten sonraki test method'larini calistirmak isterseniz
      "no tests found" uyari verir ve hic bir testi calistirmaz
     */



    @Test(dependsOnMethods = "testOtomasyonuTesti")
    public void amazonTesti(){
        System.out.println("Amazon testi PASSED");
    }

    @Test
    public void testOtomasyonuTesti(){
        //Assert.assertTrue(false);
        System.out.println("Test Otomasyonu testi PASSED");

    }

    @Test(dependsOnMethods = "amazonTesti")
    public void wiseQuarterTest(){
        System.out.println("Wise Quarter testi PASSED");
    }
}
