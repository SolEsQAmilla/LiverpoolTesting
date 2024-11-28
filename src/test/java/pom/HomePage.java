package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "mainSearchbar")
    private WebElement searchBar;

    @FindBy(css = ".o-col.col-lg-auto.d-none.d-lg-flex.text-center.order-lg-4.sessionMinWidth")
    private WebElement loginButton;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void lookForProductWithSearchBar(WebDriverWait wait, String text){
        this.sendKeysWithWait(searchBar,wait, text);
    }

    public boolean waitForInteractibleElementInHomePage(WebDriverWait wait){
        return this.waitForElementToBeRefreshed(searchBar,wait);
    }

    public void clickOnLogin(){
        this.click(loginButton);
    }

    public void sendSpecialKeyWithSearchBar(String text){
        this.sendKeys(searchBar,text);
    }
}
