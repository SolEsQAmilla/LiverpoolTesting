package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import runner.brower_manager.*;

import java.io.IOException;

public class Hooks {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private DriverManager driverManager;

    @Before
    public void setUp(){
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            driver.set(driverManager.getDriver());
            driver.get().get("https://www.liverpool.com.mx/tienda/home");
            driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if ((scenario.isFailed())) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driverManager.quitDriver();
    }

    public static WebDriver getDriver(){return driver.get();}

}
