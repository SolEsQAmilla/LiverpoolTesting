package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
    @FindBy(id = "opc_pdp_buyNowButton")
    private WebElement buyNow;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void clickOnBuyNow(){
        this.click(buyNow);
    }

    public boolean waitForInteractibleElementInSearchProductPage(WebDriverWait wait){
        return this.waitForElementToBeRefreshed(buyNow,wait);
    }
}
