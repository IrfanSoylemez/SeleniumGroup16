package com.cydeo.test.StephanieTests;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class VehicleOdometerPage extends TestBase {


    @Test
    public void truckDriverAccess() throws InterruptedException {
/*
    1. Truck driver can login Vytrack application with their credentials.
        1.1 Truck driver can access Vehicle Odometer through Fleet module.

        Given I am logged into the VyTrack page as a truck driver,
        When I click on "Vehicle Odometer",
        Then I should access the Vehicle Odometer page and see "Vehicles Odomoters" as the header.
 */
//      Given I am logged into the VyTrack page as a truck driver,
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        userNameBox.sendKeys("user46");
        WebElement passWordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passWordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        WebElement vehicleOdometerButton = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));

//      When I click on "Vehicle Odometer",
        Actions action = new Actions(driver);
        action.moveToElement(fleetButton).build().perform();
        vehicleOdometerButton.click();

//      Then I should access the Vehicle Odometer page.
        WebElement vehicleOdometerHeader = driver.findElement(By.xpath("//h1[.='Vehicles Odometers']"));
        Assert.assertTrue(vehicleOdometerHeader.isDisplayed(), "Vehicle Odomoter heading not displayed. Test FAILED");
        String actualVehicleOdometerHeader = vehicleOdometerHeader.getText();
        String expectedVehicleOdometerHeader = "Vehicles Odometers";
        Assert.assertEquals(actualVehicleOdometerHeader, expectedVehicleOdometerHeader);

//        3. Truck driver can see ALL vehicle odometer information on the Vehicle Odometer page.
        /*
        Given I am on the Vehicle Odometers page,
        When I click on "Create Vehicle Odometer" button,
        And I input an odometer value,
        And I select a date,
        And I input a driver,
        And I select a unit,
        And I select a model,
        Then I should be able to click on “Save and Close” button to create it or click on “Cancel” button to cancel it.
         */

//        When I click on "Create Vehicle Odometer" button,
        WebElement createVehicleOdometerButton = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("//a[@class='btn main-group btn-primary pull-right '].click()", createVehicleOdometerButton);


//        And I input an odometer value,
        WebElement odometerValueBox = driver.findElement(By.xpath("//input[@data-name='field__odometer-value']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(odometerValueBox));
        odometerValueBox.sendKeys("10000");



    }

    @Test
    public void storeManagerAccessCheck(){
        /*
        2. Store managers credentials should NOT allow them to access the Vehicle Odometer page.

        Given I am logging in as a Store manager,
        When I click on "Vehicle Odomoter,"
        Then I should  see an error message saying "You do not have permission to perform this action."
         */


//     Given I am logging in as a Store manager OR Sales manager,
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passWordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userNameBox.sendKeys("storemanager81");
        passWordBox.sendKeys("UserUser123");
        loginButton.click();

//      When I click on "Vehicle Odomoter,"
        WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        WebElement vehicleOdometerButton = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        Actions action = new Actions(driver);
        action.moveToElement(fleetButton).perform();
        vehicleOdometerButton.click();

//     Then I should  see an error message saying "You do not have permission to perform this action."
        WebElement errorMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }

    @Test
    public void salesManagerAccessCheck(){
         /*
        2. Sales managers credentials should NOT allow them to access the Vehicle Odometer page.

        Given I am logging in as a Sales manager,
        When I click on "Vehicle Odomoter,"
        Then I should  see an error message saying "You do not have permission to perform this action."
         */

        //     Given I am logging in as a Sales manager,
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userNameBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement passWordBox = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userNameBox.sendKeys("salesmanager146");
        passWordBox.sendKeys("UserUser123");
        loginButton.click();

//      When I click on "Vehicle Odomoter,"
        WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        WebElement vehicleOdometerButton = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        Actions action = new Actions(driver);
        action.moveToElement(fleetButton).perform();
        vehicleOdometerButton.click();

//     Then I should  see an error message saying "You do not have permission to perform this action."
        WebElement errorMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }


}
