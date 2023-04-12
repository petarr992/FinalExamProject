import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{
    @FindBy(className = "product_sort_container")
    WebElement sortDropDown;
    @FindBy(id = "shopping_cart_container")
    WebElement cart;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement labsOnesie;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement boltTShirt;

    @FindBy(css = "#shopping_cart_container span")
    WebElement cartnum;

    public InventoryPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void SortItemByValue(){
        Select drop = new Select(sortDropDown);
        drop.selectByValue("lohi");
    }
    public String Cart(){
        return cartnum.getText();
    }
    public void AddLabsOnesie(){
        labsOnesie.click();
    }
    public void AddBikeLight(){
        bikeLight.click();
    }
    public void AddBoltTShirt(){
        boltTShirt.click();
    }
    public void ClickOnCart(){
        cart.click();}
}

