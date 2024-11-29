package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchedProductsPage extends BasePage{
    @FindBy(className = "o-nullproduct-query")
    private WebElement notFoundProduct;

    public WebElement getNotFoundProduct() {
        return notFoundProduct;
    }


    public List<WebElement> lookForProducts(String product, WebDriver driver){
        return driver.findElements(By.xpath("//*[contains(@href,'"+product+"')]"));
    }

    public WebElement lookForProduct(String product, WebDriver driver){
        return driver.findElement(By.xpath("//*[contains(@href,'"+product+"')]"));
    }

    public void clickOnFilter(String filter, String value, WebDriver driver){
        this.click(driver.findElement(By.xpath("//*[contains(@id,'"+filter.toUpperCase()+ "-" + value
                + "') or contains(@id,'"+filter.toLowerCase()+"-" + value +
                "') or contains(@id,'"+filter.substring(0, 1).toUpperCase() + filter.substring(1)+ "-" + value +"')]")));
    }

    public WebElement lookForFilter(String filter, String value, WebDriver driver){
        return driver.findElement(By.xpath("//*[contains(@id,'"+filter.toUpperCase()+ "-" + value
                + "') or contains(@id,'"+filter.toLowerCase()+"-" + value +
                "') or contains(@id,'"+filter.substring(0, 1).toUpperCase() + filter.substring(1)+ "-" + value +"')]"));
    }

    public SearchedProductsPage(WebDriver driver){
        super(driver);
    }

    public boolean waitForElementInSearchProductsPage(WebElement element,WebDriverWait wait){
        return this.waitForElement(element,wait);
    }

    public boolean checkIfElementIsClickeableSearchedPage(WebElement element, WebDriverWait wait){
        return this.waitForElementToBeClickeable(element, wait);
    }

    public boolean waitForInteractibleElementInSearchProductsPage(WebElement element,WebDriverWait wait){
        return this.waitForElementToBeRefreshed(element,wait);
    }

    public void clickOnProduct(WebElement element){
        this.click(element);
    }

}
