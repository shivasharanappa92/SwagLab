import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import Page_factory.login_page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class example {
    public static void main(String[] args) {
       Properties prop= new Properties();
        try {
            prop.load(new FileInputStream(new File("./src/test/java/datasets.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        login_page l=new login_page(driver);
        l.send_username(prop.getProperty("username1"));
        l.send_password(prop.getProperty("password"));
        l.click_loginbutton();
        driver.findElement(By.xpath("//div[@class='inventory_item_name']")).click();


    }

}
