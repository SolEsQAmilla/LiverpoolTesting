package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodeVerificationPage extends BasePage{
    @FindBy(css = ".c4a44f9dd.c08fa9ae3")
    private WebElement verificationCodeText;

    private String verificationCodePageMainText = "Código de verificación";

    public boolean checkIfWeAreOnVerificationCodePage(){
        boolean found = false;
        if(this.getText(verificationCodeText).equalsIgnoreCase(verificationCodePageMainText)){
            found = true;
        }
        return  found;
    }

    public CodeVerificationPage(WebDriver driver){
        super(driver);
    }
}
