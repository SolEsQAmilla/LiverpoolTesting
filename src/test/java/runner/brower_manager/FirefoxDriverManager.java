package runner.brower_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void createDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
