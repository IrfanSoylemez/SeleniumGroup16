package com.cydeo.test.StephanieTests;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VehicleOdometerPage extends TestBase {

    @Test
    public void truckDriverAccess(){
/*
    1. Truck driver can login Vytrack application with their credentials.
        1.1 Truck driver can access Vehicle Odometer through Fleet module.

        Given I am logged into the VyTrack page as a truck driver,
        When I click on "Vehicle Odometer",
        Then I should access the Vehicle Odometer page.
 */
//      Given I am logged into the VyTrack page as a truck driver,
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox.sendKeys("user46");
        WebElement passWordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passWordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }

    @Test
    public void vehicleOdometerAccess(){

    }


}
