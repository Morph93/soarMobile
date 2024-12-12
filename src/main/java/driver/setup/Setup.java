package driver.setup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {
    public static Setup instance;
    public static AndroidDriver<MobileElement> driver;
    public static FluentWait<AndroidDriver<MobileElement>> wait;

    private Setup() throws MalformedURLException {
        initializeDriver();
        initializeWait();
    }

    public static Setup getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new Setup();
        }
        return instance;
    }

    /**
     * Make sure that you have application installed on the device.
     * Change deviceName to match the one on which you're executing.
     * Change platformVersion to match android version of the device on which you're executing.
     */
    private void initializeDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set Appium desired capabilities
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Pixel 5 API 30");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "org.wikipedia.alpha");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        caps.setCapability("newCommandTimeout", 30);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", false);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
    }

    private void initializeWait() {
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

}