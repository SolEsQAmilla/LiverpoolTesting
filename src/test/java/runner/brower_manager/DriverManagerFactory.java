package runner.brower_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverManagerFactory {

    private static final Logger log = LogManager.getLogger(DriverManagerFactory.class);

    public static DriverManager getManager(DriverType type){
        DriverManager driverManager = null;
        switch(type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                log.info("invalid browser");
                break;
        }
        return driverManager;
    }
}
