import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckOutPage checkOutPage;

    @BeforeMethod
    public void Setup() {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }
    @Test
    public void ItemTotalPrice(){
        loginPage.Login();
        inventoryPage.SortItemByValue();
        inventoryPage.AddLabsOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickOnCheckOut();
        checkOutPage.EnterFirstName();
        checkOutPage.EnterLastName();
        checkOutPage.EnterZipCode();
        checkOutPage.ClickOnContinueButton();
        checkOutPage.ItemPrice();
        Assert.assertEquals(checkOutPage.ItemPrice(), "Item total: $33.97");
    }
    @Test
    public void TotalPriceTest(){
        loginPage.Login();
        inventoryPage.SortItemByValue();
        inventoryPage.AddLabsOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickOnCheckOut();
        checkOutPage.EnterFirstName();
        checkOutPage.EnterLastName();
        checkOutPage.EnterZipCode();
        checkOutPage.ClickOnContinueButton();
        checkOutPage.TotalPrice();
        Assert.assertEquals(checkOutPage.TotalPrice(),"Total: $36.69");

    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}


