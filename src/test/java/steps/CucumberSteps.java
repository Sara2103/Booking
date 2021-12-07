package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BookingHomePage;
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

    @When("I change language {string}")
    public void iChangeLanguage(String language) {
        BookingHomePage b = new BookingHomePage(driver, wait);
        b.chooseLanguage(language);
    }

    @And("I enter destination {string}")
    public void iEnterDestination(String destinationName) {
        BookingHomePage b = new BookingHomePage(driver, wait);
        b.enterDestination(destinationName);
    }

    @And("I select dateFrom and dateTo {string} {string}")
    public void iSelectDateFromAndDateTo(String dateFrom, String dateTo) {
        BookingHomePage b = new BookingHomePage(driver, wait);
        b.selectDates(dateFrom, dateTo);
    }

    @And("I choose number of person, children and rooms {string} {string} {string} {string}")
    public void iChooseNumberOfPersonChildrenAndRooms(String adultsNum, String childrenNum, String ageValue, String roomsNum) {
        BookingHomePage b = new BookingHomePage(driver, wait);
        b.addedPersonInfo(adultsNum, childrenNum, ageValue, roomsNum);
    }

    @And("I click button Search")
    public void iClickButtonSearch() throws InterruptedException {
        BookingHomePage b = new BookingHomePage(driver, wait);
        b.clickSearch();
    }

    //tear down
    @After
    public void quit() {
        //quitDriver();
    }
}
