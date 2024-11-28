package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    @FindBy(css = ".input.c4ea79246.c882875d6")
    private WebElement email;

    @FindBy(css = ".input.c4ea79246.c2946f7ad")
    private WebElement password;

    @FindBy(css = ".c0a486a03.c3a925026.cc4e2760d.cf0fbb154.c4b20090f")
    private WebElement login;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void sendKeysInUserName(WebDriverWait wait, String text){
        this.sendKeysWithWait(email,wait,text);
    }

    public void sendKeysInPassword(WebDriverWait wait, String text){
        this.sendKeysWithWait(password,wait,text);
    }

    public void clickOnLogin(){
        this.click(login);
    }

    public boolean waitForInteractibleElementInLoginPage(WebDriverWait wait){
        return this.waitForElementToBeRefreshed(email,wait);
    }

}
