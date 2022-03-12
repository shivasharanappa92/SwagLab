package TestNg;


import Page_factory.HomePage;
import Page_factory.login_page;
import UserData.ExcelHandel;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



public class LoginPage {

    public WebDriver driver = null;
    Properties prop=null;

    @BeforeMethod
    public void setup() {

        prop = new Properties();
        try {
            prop.load(new FileInputStream(new File("./src/test/java/UserData/datasets.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }
    @Test(dataProvider="supplyData")
    public void login(String Username,String password,String credentialType) throws InterruptedException {
        Thread.sleep(2000);
        login_page l=new login_page(driver);
        l.send_username(Username);
        Thread.sleep(2000);
        l.send_password(password);
        Thread.sleep(2000);
        l.click_loginbutton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.Cart)).click();
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='inventory_sidebar_link']"))).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.AddCart_product1)).click();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.AddCart_product2)).click();
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.Reset_menu)).click();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Thread.sleep(2000);
        h.clickOnCross();
        Thread.sleep(2000);
        h.click_menu();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='about_sidebar_link']"))).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
        driver.quit();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user-name']"))).sendKeys(Username);
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys(password);
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']"))).click();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='react-burger-menu-btn']"))).click();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        System.out.println(driver.getCurrentUrl());
        driver.quit();


    }




    @DataProvider
    public Object[][] supplyData() throws IOException {
        ExcelHandel excelUtility = new ExcelHandel("./src/test/java/UserData/DataSet.xlsx");

        int rowCount = excelUtility.getRowCount("SheetA");
        int colCount = excelUtility.getCellCount("SheetA", 1);

        String[][] data = new String[rowCount][colCount];

        for (int r = 1; r <= rowCount; r++) {

            for (int c = 0; c < colCount; c++) {

                data[r - 1][c] = excelUtility.getCellData("SheetA", r, c);

            }

        }

        return data;

    }



}


