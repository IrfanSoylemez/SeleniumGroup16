package com.cydeo.test.inga;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T02_Test extends TestBase {

    @Test
    public void vehicleContract_login() {

        driver.get("https://qa2.vytrack.com/user/login");

        WebElement inputUserName = driver.findElement(By.id("prependedInput"));
        inputUserName.sendKeys("storemanager81");

        WebElement inputPassword = driver.findElement(By.id("prependedInput2"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();
    }

}
//
////    @Test
//
//    public void access_create_vehicleContract() {

//        WebElement fleetDropdown = driver.findElement(By.className("title title-level-1"));
//        fleetDropdown.sendKeys();
//
//        WebElement vehicleContractBtn = driver.findElement(By.className("dropdown dropdown-level-1"));
//        vehicleContractBtn.sendKeys();

//        Select fleetDropdown = new Select(driver.findElement(By.className("title title-level-1")));
//
//        Select vehicleContractBtn = new Select(driver.findElement(By.className("dropdown dropdown-level-1")));
//
//