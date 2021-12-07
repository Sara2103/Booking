package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingHomePage;
import pages.BookingSearchResults;
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

    @Then("I should see desired choice")
    public void iShouldSeeDesiredChoice() throws InterruptedException {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);

        //Date format: day of the week, DD. month YYYY. / Day of the week DD Month YYYY
        bs.checkBooking("Lisabon", "nedelja, 2. januar 2022.", "četvrtak, 13. januar 2022.",
                "6", "1", "3", "4");
    }

    @And("I check the budget")
    public void iCheckTheBudget() {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.checkBudget();
    }

    @And("I check the distance in the filters")
    public void iCheckTheDistanceInTheFilters() {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.checkDistanceFromCentre();
    }

    //tear down
    @After
    public void quit() {
        //quitDriver();
    }


}
