package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.*;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected SearchedProductsPage searchedProductsPage = PageFactory.initElements(driver, SearchedProductsPage.class);
    protected ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected CodeVerificationPage codeVerificationPage = PageFactory.initElements(driver, CodeVerificationPage.class);
}
