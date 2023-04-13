import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage {
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement zipCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(css = "div.summary_subtotal_label")
    WebElement itemPrice;


    public CheckOutPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void EnterFirstName(){
        firstName.sendKeys("Petar");
    }
    public void EnterLastName(){
        lastName.sendKeys("Radosavljevic");
    }
    public void EnterZipCode(){
        zipCode.sendKeys("11030");
    }
    public void ClickOnContinueButton(){
        continueButton.click();
    }
    public String ItemPrice(){
        return itemPrice.getText();


    }
}


