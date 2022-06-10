package com.cydeo.test.marina;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US12_AC1_Sc2 extends TestBase {

    @Test
    public void kpj() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("user45");
        WebElement password = driver.findElement(By.cssSelector("input#prependedInput2"));
        password.sendKeys("UserUser123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[.='Log in']"));
        loginBtn.click();
        Thread.sleep(3000);

        WebElement fleetBtn = driver.findElement(By.xpath("(//span[contains(text(), ' Fleet')]) [1]"));
        Thread.sleep(3000);
        WebElement vehicleServiceLog = driver.findElement(By.xpath("//span[.= 'Vehicle Services Logs']"));

        Actions action = new Actions (driver);
        action.moveToElement(fleetBtn).perform();
        vehicleServiceLog.click();
        Thread.sleep(4000);

        //AND I click on "create Vehicle service logs""
        WebElement createVehicleService = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));

        createVehicleService.click();
        Thread.sleep(4000);


    }
}

/*
AC2.Verify that truck driver should be able to create Vehicle service logs or cancel it

Scenario 2. Truck driver is able to create Vehilce service logs	"

GIVEN I am truck driver on Vytrack Home page,
WHEN I click on ""Fleet"" button,
AND I click on ""Vehicle serviece log"",
AND I click on "create Vehicle service logs"" ,
THEN I am able to creat a Services. "
 */