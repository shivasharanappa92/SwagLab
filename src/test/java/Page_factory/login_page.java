package Page_factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
    WebDriver driver;


    public  login_page(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='user-name']")
    public WebElement username;

    public void send_username(String uname)
    {
        username.sendKeys(uname);
    }

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    public void send_password(String pass)
    {
        password.sendKeys(pass);
    }

    @FindBy(xpath ="//input[@id='login-button']")
    public WebElement login_button;

    public void click_loginbutton()
    {
        login_button.click();
    }

}
