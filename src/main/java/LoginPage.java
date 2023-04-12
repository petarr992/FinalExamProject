import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = ".error-message-container h3")
    WebElement errorMessage;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextMessage() {
        return errorMessage.getText();
    }

    public void Login() {
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    public void LoginWithInvalidPass() {
        userName.sendKeys("standard_user");
        password.sendKeys("blabla");
        loginButton.click();
    }

    public void LoginWithInvalidUserName() {
        userName.sendKeys("standard.user");
        password.sendKeys("secret_sauce");
        loginButton.click();
    }

    public void LoginWithInvalidUserAndPass() {
        userName.sendKeys("standard.user");
        password.sendKeys("blabla");
        loginButton.click();
    }

    public void LoginWithNoData() {
        loginButton.click();
    }
}

