package steps;

import driver.setup.Setup;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.util.List;

public class Steps {
    private final AndroidDriver<MobileElement> driver;
    private final FluentWait<AndroidDriver<MobileElement>> wait;

    public Steps() {
        try {
            Setup.getInstance();
            driver = Setup.driver;
            wait = Setup.wait;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    @When("Scroll down")
    public void scroll_down() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy
                        .AndroidUIAutomator("new UiSelector().text(\"In the news\")")
                ));

         driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"org.wikipedia.alpha:id/fragment_main_view_pager\")).scrollForward()"
        ));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("Open My lists page and wait three seconds")
    public void open_my_lists_page_and_wait_three_seconds() {
        MobileElement myLists = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"My lists\")"
        ));
        myLists.click();
    }

    @When("Open History page and wait three seconds")
    public void open_history_page_and_wait_three_seconds() {
        MobileElement history = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"History\")"
        ));
        history.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("Open Nearby page and wait three seconds")
    public void open_nearby_page_and_wait_three_seconds() {
        MobileElement location = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"Nearby\")"
        ));
        location.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("Go back to Home page")
    public void go_back_to_home_page() {
        MobileElement explore = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"Explore\")"
        ));
        explore.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Scroll up to the top")
    public void scroll_up_to_the_top() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"org.wikipedia.alpha:id/fragment_main_view_pager\")).scrollBackward()"
        ));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @When("Click search bar")
    public void click_search_bar() {
        MobileElement searchBar = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Search Wikipedia\")"
        ));
        searchBar.click();
    }

    @When("Enter New York")
    public void enter_new_york() {
        MobileElement inputTextSearchBar = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_src_text\")")
        ));
        inputTextSearchBar.sendKeys("New York");
    }

    @When("Validate that results are shown")
    public void validate_that_results_are_shown() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy
                        .AndroidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/page_list_item_container\")")
                ));
        List<MobileElement> listOfElements = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceId(\"org.wikipedia.alpha:id/page_list_item_container\")"
        ));
        if (listOfElements.size() > 1) {
            System.out.println("The list contains more than one element. Current size: " + listOfElements.size());
        } else {
            throw new AssertionError("The list does not contain more than one element. Current size: " + listOfElements.size());
        }
    }

    @Then("Click X twice")
    public void click_x_twice() {
        MobileElement closeButton = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceId(\"org.wikipedia.alpha:id/search_close_btn\")"
        ));
        closeButton.click();
        closeButton.click();
    }


    @When("User opens settings")
    public void user_opens_settings() {
        MobileElement menuButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/menu_overflow_button\")")
        ));
        menuButton.click();
        MobileElement settings = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/explore_overflow_settings\")")
        ));
        settings.click();

    }

    @When("Disables all options")
    public void disables_all_options() {
        wait.until(ExpectedConditions
                .elementToBeClickable(MobileBy
                        .AndroidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/switchWidget\").instance(0)")
                ));

        List<MobileElement> listOfElements = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceId(\"org.wikipedia.alpha:id/switchWidget\")"
        ));
        for (MobileElement element : listOfElements) {
            element.click();
        }
    }

    @Then("User goes to the home page")
    public void user_goes_to_the_home_page() {
        MobileElement backButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().description(\"Navigate up\")")
        ));
        backButton.click();
    }

}
