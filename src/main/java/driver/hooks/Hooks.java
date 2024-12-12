package driver.hooks;

import driver.setup.Setup;
import driver.teardown.Teardown;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void initializeDriver() {
        try {
            Setup.getInstance();
            System.out.println("Driver initialized successfully.");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize the Appium driver: " + e.getMessage(), e);
        }
    }

    @After
    public void tearDownDriver() {
        new Teardown().quitDriver();
        System.out.println("Driver teardown completed.");
    }
}