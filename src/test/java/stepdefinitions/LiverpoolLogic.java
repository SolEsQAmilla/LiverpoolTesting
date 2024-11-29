package stepdefinitions;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.time.Duration;
import java.util.List;

public class LiverpoolLogic extends TestBase {
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
    private String productName;
    private List<WebElement> products;

    @Given("I want the product {string}")
    public void iWantTheProduct(String product) throws Throwable{
        productName = product;
        homePage.waitForInteractibleElementInHomePage(wait);
        homePage.lookForProductWithSearchBar(wait,product);
    }

    @When("I look for the product")
    public void iLookForTheProduct() throws Throwable{
        homePage.sendSpecialKeyWithSearchBar("ENTER");
    }

    @Then("I get the information from the product")
    public void iGetTheInformationFromTheProduct() throws Throwable{
        productName = productName.toLowerCase().replaceAll(" ","-");
        ExtentCucumberAdapter.getCurrentStep().info(MarkupHelper.createLabel(productName, ExtentColor.BLUE));
        Assert.assertTrue("No products displayed", searchedProductsPage.waitForElementInSearchProductsPage(searchedProductsPage.getNotFoundProduct(),wait));
        Assert.assertFalse("No products found",searchedProductsPage.waitForElementInSearchProductsPage(searchedProductsPage.lookForProduct(productName, driver),wait));
        products = searchedProductsPage.lookForProducts(productName, driver);
        Assert.assertTrue("The product was not found",products.stream().anyMatch(e -> e != null));
    }

    @But("I look for the product with the following filters:")
    public void iLookForTheProductWithTheFollowingFilters(List<List<String>> filters) throws Throwable{
        String value;
        for(List<String> filter : filters){
            if(filter.get(0).equalsIgnoreCase("Price")){
                String[] range = filter.get(1).replaceAll("\\$","").split("-");
                String [] firstRange = range[0].split("\\.");
                String [] secondRange = range[1].split("\\.");
                value = firstRange[0] + "-" + secondRange[0];
            }else{
                value = filter.get(1);
            }
            searchedProductsPage.waitForInteractibleElementInSearchProductsPage(searchedProductsPage.lookForFilter(filter.get(0),value,driver), wait);
            searchedProductsPage.clickOnFilter(filter.get(0),value,driver);
        }
    }

    @And("I click on {string}")
    public void iClickOn(String element) throws Throwable{
        switch(element.toLowerCase()){
            case "product":
                searchedProductsPage.waitForInteractibleElementInSearchProductsPage(products.getFirst(), wait);
                searchedProductsPage.checkIfElementIsClickeableSearchedPage(products.getFirst(), wait);
                searchedProductsPage.clickOnProduct(products.getFirst());
                break;
            case "buy now":
                productPage.waitForInteractibleElementInSearchProductPage(wait);
                productPage.clickOnBuyNow();
                break;
            case "login":
                loginPage.clickOnLogin();
                break;
            case "login home page":
                homePage.clickOnLogin();
                break;
            default:
                ExtentCucumberAdapter.getCurrentStep().info(MarkupHelper.createLabel("invalid identifier", ExtentColor.RED));
                break;
        }
    }

    @And("I need credentials for an existing account:")
    public void iNeedCredentialsForAnExistingAccount(List<List<String>> credentials) throws Throwable{
        loginPage.waitForInteractibleElementInLoginPage(wait);
        for(List<String> credential : credentials){
            if(credential.get(0).equalsIgnoreCase("username")){
                loginPage.sendKeysInUserName(wait,credential.get(1));
            }else{
                loginPage.sendKeysInPassword(wait,credential.get(1));
            }
        }
    }

    @Then("login was successful")
    public void loginWasSuccessful() throws Throwable{
        Assert.assertTrue(codeVerificationPage.checkIfWeAreOnVerificationCodePage());
    }

}
