package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void sendKeysWithWait(By element, WebDriverWait wait, String text){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Could not write into the element " + e);
        }
    }

    public void sendKeysWithWait(WebElement element, WebDriverWait wait, String text){
        try{
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Could not write into the element " + e);
        }
    }

    public boolean waitForElement(By element, WebDriverWait wait){
        boolean unfound = false;
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            unfound = true;
        }
        return unfound;
    }

    public boolean waitForElement(WebElement element, WebDriverWait wait){
        boolean unfound = false;
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            unfound = true;
        }
        return unfound;
    }

    public boolean waitForElementToBeRefreshed(WebElement element, WebDriverWait wait){
        boolean unfound = false;
        try{
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        } catch (TimeoutException e) {
            unfound = true;
        }
        return unfound;
    }

    public boolean waitForElementToBeClickeable(WebElement element, WebDriverWait wait){
        boolean unfound = false;
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            unfound = true;
        }
        return unfound;
    }

    public void sendKeys(By element, String text){
        try{
            switch(text){
                case "ENTER":
                    driver.findElement(element).sendKeys(Keys.ENTER);
                    break;
                default:
                    driver.findElement(element).sendKeys(text);
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not write into the element " + e);
        }
    }

    public void sendKeys(WebElement element, String text){
        try{
            switch(text){
                case "ENTER":
                    element.sendKeys(Keys.ENTER);
                    break;
                default:
                    element.sendKeys(text);
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not write into the element " + e);
        }
    }

    public void click(WebElement element){
        try{
                element.click();
        } catch (Exception e) {
            throw new RuntimeException("Could not perform click into the element " + e);
        }
    }

    public boolean isDisplayed(WebElement element){
        boolean unfound = false;
        try {
            element.isDisplayed();
        } catch(NoSuchElementException e) {
            unfound = true;
        }
        return unfound;
    }

    public String getText(WebElement element){
        return element.getText();
    }
}

