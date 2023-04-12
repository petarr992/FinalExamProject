import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void Setup() {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
    }
    @Test
    public void LoginOnPageWithValidData() {
        loginPage.Login();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void WrongPassLogin(){
        loginPage.LoginWithInvalidPass();
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void WrongUserLogin(){
        loginPage.LoginWithInvalidUserName();
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void WrongUserAndPassLogin(){
        loginPage.LoginWithInvalidUserAndPass();
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void LoginWithNoData(){
        loginPage.LoginWithNoData();
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username is required");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
