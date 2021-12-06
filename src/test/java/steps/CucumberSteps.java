package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import tests.BaseTest;


public class CucumberSteps extends BaseTest {

    @Before
    public void init(){
        init("Chrome", "96", 30);
    }

    @Given("I am on booking home page")
    public void iAmOnBookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @After
    public void quit() {
        quitDriver();
    }
}
