package com.cydeo.test.marina;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.Vytrack_logins;
import org.testng.annotations.Test;

public class US12_AC1_Sc3 extends TestBase {

    @Test
    public void Test1(){
        Vytrack_logins.vytrack_truck_store_manager(driver);

    }


}
