package StepDefinations;

import BasePackage.Base;
import Page_factory.HomePage;
import Page_factory.login_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CucumberMain extends Base {


    @Given("^I visit the website$")
    public void i_visit_the_website() throws Throwable {
        prop= new Properties();
        try {
            prop.load(new FileInputStream(new File("./src/test/java/UserData/datasets.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


    }

    @When("^I enter user name as standard_user and password$")
    public void i_enter_user_name_as_standarduser_and_password() throws Throwable {
        login_page l=new login_page(driver);
        Thread.sleep(2000);
        l.send_username(prop.getProperty("username1"));
        Thread.sleep(2000);
        l.send_password(prop.getProperty("password"));

    }

    @Then("^user should login to main page$")
    public void user_should_login_to_main_page() throws Throwable {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


    }

    @And("^click login button$")
    public void click_login_button() throws Throwable {
        login_page l=new login_page(driver);
        Thread.sleep(2000);
        l.click_loginbutton();

    }

    @Then("^user shouldn't login to main page$")
    public void user_shouldnt_login_to_main_page()  {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        driver.quit();


    }
    @And("^browser should close$")
    public void browser_should_close() throws Throwable {
        login_page l=new login_page(driver);
        driver.quit();

    }
    @When("^I enter user name  as locked_out_user and password$")
    public void i_enter_user_name_as_lockedoutuser_and_password() throws InterruptedException {
        login_page l=new login_page(driver);
        Thread.sleep(2000);
        l.send_username(prop.getProperty("username2"));
        Thread.sleep(2000);
        l.send_password(prop.getProperty("password"));
    }
    @When("^I enter user name as problem_user and password$")
    public void i_enter_user_name_as_problemuser_and_password() throws InterruptedException {
        login_page l=new login_page(driver);
        Thread.sleep(2000);
        l.send_username(prop.getProperty("username3"));
        Thread.sleep(2000);
        l.send_password(prop.getProperty("password"));
    }
    @When("^I enter user name as performance_glitch_user and password$")
    public void i_enter_user_name_as_performanceglitchuser_and_password() throws InterruptedException {
        login_page l=new login_page(driver);
        Thread.sleep(2000);
        l.send_username(prop.getProperty("username4"));
        Thread.sleep(2000);
        l.send_password(prop.getProperty("password"));
    }


    @When("^I select about from menu$")
    public void i_select_about_from_menu() throws InterruptedException {
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        h.clickOnCross();
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='about_sidebar_link']"))).click();

    }

    @When("^I select Reset app from menu$")
    public void i_select_reset_app_from_menu() throws InterruptedException {
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.AddCart_product1)).click();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.AddCart_product2)).click();
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(h.Reset_menu)).click();


    }

    @When("^I select Logout from menu and got to login page$")
    public void i_select_logout_from_menu() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        login_page l=new login_page(driver);
        l.send_username(prop.getProperty("username1"));
        l.send_password(prop.getProperty("password"));
        l.click_loginbutton();
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

    @Then("^I should see all items on main pages$")
    public void i_should_see_all_items_on_main_pages() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }

    @Then("^I should take to about page of swag lab$")
    public void i_should_to_take_about_page_of_swag_lab()  {
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
        driver.quit();



    }

    @Then("^I should to see reset of swag lab$")
    public void i_should_to_see_reset_of_swag_lab() {
        Assert.assertEquals( driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

    }



    @And("^I select All items$")
    public void i_select_all_items() throws InterruptedException {
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        h.clickOnCart();
        Thread.sleep(2000);
        h.click_menu();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='inventory_sidebar_link']"))).click();

    }
    @When("^I select Logout from menu with problem_user and got to login page$")
    public void i_select_logout_from_menu_with_problemuser_and_got_to_login_page() throws InterruptedException {
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        System.out.println(driver.getCurrentUrl());
        driver.quit();


    }

    @When("^I select about from menu with problem_user$")
    public void i_select_about_from_menu_with_problemuser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        login_page l=new login_page(driver);
        l.send_username(prop.getProperty("username3"));
        l.send_password(prop.getProperty("password"));
        l.click_loginbutton();
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='about_sidebar_link']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        driver.quit();

    }
    @When("^I select Logout from menu with performace_glitch_user and got to login page$")
    public void i_select_logout_from_menu_with_performaceglitchuser_and_got_to_login_page() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        login_page l=new login_page(driver);
        l.send_username(prop.getProperty("username4"));
        l.send_password(prop.getProperty("password"));
        l.click_loginbutton();
        HomePage h=new HomePage(driver);
        Thread.sleep(2000);
        h.click_menu();
        Thread.sleep(2000);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']"))).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
        driver.quit();

    }


}
