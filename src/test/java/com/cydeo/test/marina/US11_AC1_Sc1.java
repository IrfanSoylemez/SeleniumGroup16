package com.cydeo.test.marina;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class US11_AC1_Sc1 {

    @Test
    public void seeAllVehilceServiceLogs() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        WebElement username =  Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys(ConfigurationReader.getProperty("truckDriver46"));
        WebElement password =  Driver.getDriver().findElement(By.cssSelector("input#prependedInput2"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        WebElement loginBtn =  Driver.getDriver().findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();
        Thread.sleep(3000);

        WebElement fleetBtn = Driver.getDriver().findElement(By.xpath("(//span[contains(text(), ' Fleet')]) [1]"));
        Thread.sleep(3000);
        WebElement vehicleServiceLog =  Driver.getDriver().findElement(By.xpath("//span[.= 'Vehicle Services Logs']"));

        Actions action = new Actions (Driver.getDriver());
        action.moveToElement(fleetBtn).perform();
        action.moveToElement(vehicleServiceLog).click().perform();
        Thread.sleep(4000);

        String expectedTitle = "Vehicle Services Logs - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed");
        Driver.closeDriver();
    }


}

/*
GIVEN I am a truck driver on Vytrack Home page,
WHEN I click on "Fleet" button,
AND I click on "Vehicle serviece log",
THEN I see the Vehicle Services Logs page.


Truck Drivers:  	user45, Password : UserUser123

https://qa2.vytrack.com/user/login



 */