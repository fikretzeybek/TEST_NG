package tests.f17cros;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class F01 extends TestBaseCross {

    @Test
    public void aramaTesti(){

       driver.get(ConfigReader.getProperty("toUrl"));




    }
}
