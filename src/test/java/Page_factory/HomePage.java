package Page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath=("//button[@id='react-burger-menu-btn']"))
    public WebElement menu;
    public By click_menu()
    {
        menu.click();

        return null;
    }

    @FindBy(xpath=("//a[@id='about_sidebar_link']"))
    public WebElement about_menu;
    public By click_aboutMenu()
    {
        about_menu.click();
        return null;
    }
    @FindBy(xpath=("//a[@id='reset_sidebar_link']"))
    public WebElement Reset_menu;
    public By click_ResetMenu()
    {
        Reset_menu.click();
        return null;
    }
    @FindBy(xpath=("//a[@id='inventory_sidebar_link']']"))
    public WebElement AllItems_menu;
    public By click_AllItemsMenu()
    {
        AllItems_menu.click();
        return null;
    }
    @FindBy(xpath=("//a[@id='logout_sidebar_link']"))
    public WebElement Logout_menu;
    public By click_LogoutMenu()
    {
        Logout_menu.click();
        return null;
    }

    @FindBy(xpath=("//a[@class='shopping_cart_link']"))
    public WebElement Cart;
    public void clickOnCart()
    {
        Cart.click();
    }

    @FindBy(xpath =("//button[@id='react-burger-cross-btn']"))
    public WebElement cross;
    public void clickOnCross()
    {
        cross.click();
    }

    @FindBy(xpath=("//button[@id='add-to-cart-sauce-labs-backpack']"))
    public WebElement AddCart_product1;
    public By clickToAddcart_p1()
    {
        AddCart_product1.click();
        return null;
    }


    @FindBy(xpath=("//button[@id='add-to-cart-sauce-labs-bike-light']"))
    public WebElement AddCart_product2;
    public By clickToAddcart_p2()
    {
        AddCart_product2.click();
        return null;
    }


}
