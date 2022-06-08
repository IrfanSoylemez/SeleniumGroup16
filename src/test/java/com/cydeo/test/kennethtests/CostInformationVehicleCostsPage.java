package com.cydeo.test.kennethtests;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CostInformationVehicleCostsPage {
    WebDriver driver;

    @BeforeMethod
    public void startUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void storeManagerVerification() throws InterruptedException {

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameBox.sendKeys("storemanager81");
        passwordBox.sendKeys("UserUser123");

        Thread.sleep(3000);
        loginBtn.click();


        WebElement fleetBtn = driver.findElement(By.xpath("(//span[contains(text(), 'Fleet')])[1]"));
        WebElement vehicleCostsBtn = driver.findElement(By.xpath("//span[contains(text(), 'Vehicle Costs')]"));


        //mouse hover
        Actions action = new Actions(driver);
        action.moveToElement(fleetBtn).perform();

        Thread.sleep(3000);

        vehicleCostsBtn.click();

//        WebElement grid = driver.findElement(By.xpath("//tbody[@class='grid-body']"));
//        Assert.assertTrue(grid.isDisplayed(), "Not displayed");


        List<WebElement> listOfCarsCostInfo = driver.findElements(By.xpath("//tr[@class = 'grid-row row-click-action']"));
        for (WebElement each : listOfCarsCostInfo) {
            System.out.println(each.getText());
        }

        Assert.assertTrue(!listOfCarsCostInfo.isEmpty(), "Not able to see cars cost information");


    }

    @Test
    public void salesManagerVerification(){

        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameBox.sendKeys("salesmanager146");
        passwordBox.sendKeys("UserUser123");
        loginBtn.click();


        WebElement fleetBtn = driver.findElement(By.xpath("(//span[contains(text(), 'Fleet')])[1]"));
        WebElement vehicleCostsBtn = driver.findElement(By.xpath("//span[contains(text(), 'Vehicle Costs')]"));

        //mouse hover
        Actions action = new Actions(driver);
        action.moveToElement(fleetBtn).perform();

        vehicleCostsBtn.click();

        WebElement grid = driver.findElement(By.xpath("//tbody[@class='grid-body']"));
        Assert.assertTrue(grid.isDisplayed());


        List<WebElement> listOfCarsCostInfo = driver.findElements(By.xpath("//tr[@class = 'grid-row row-click-action']"));
        for (WebElement each : listOfCarsCostInfo) {
            System.out.println(each.getText());
        }

        Assert.assertTrue(!listOfCarsCostInfo.isEmpty(), "Not able to see cars cost information");


    }

}
/*
Credentials:
StoreManager:
username: storemanager81
password: UserUser123

SalesManager:
username: salesmanager146
password: UserUser123
 */

/*
1.
Given: I am on the homepage of vytrack application
When: I click on Fleet button
And: I click on Vehicle Costs button
Then: I should be able to see all cars' cost informations on the Vehicle Costs page.
 */
