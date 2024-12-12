package driver.teardown;

import driver.setup.Setup;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;

public class Teardown {
    private final AndroidDriver<MobileElement> driver;

    public Teardown() {
        this.driver = Setup.driver;
    }

    @AfterEach
    public void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Driver quit successfully.");
            } catch (Exception e) {
                System.err.println("Error during driver quit: " + e.getMessage());
            } finally {
                Setup.driver = null;
                Setup.instance = null;
            }
        }
    }
}