package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingDetailsInfo;
import pages.BookingHomePage;
import pages.BookingSearchResults;
import pages.BookingSelectedHotel;
import tests.BaseTest;


public class CucumberSteps extends BaseTest {

    @Before
    public void init() {
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

        //Date format: day of the week, DD. month YYYY. / Day of the week DD Month YYYY     | "nedelja, 2. januar 2022." "četvrtak, 13. januar 2022." | "utorak, 22. februar 2022.", "četvrtak, 3. mart 2022."
        bs.checkBooking("Lisabon", "nedelja, 2. januar 2022.", "četvrtak, 13. januar 2022.",
                "6", "1", "3", "4");
    }

    @And("I check the budget filters")
    public void iCheckTheBudgetFilters() {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.checkBudget();
    }

    @And("I check the distance filters")
    public void iCheckTheDistanceFilters() {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.checkDistanceFromCentre();
    }

    @And("I select best reviewed and lowest price")
    public void iSelectBestReviewedAndLowestPrice() {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.selectBestReviewedLowestPrice();
    }

    @And("I click the first best choice")
    public void iClickTheFirstBestChoice() throws InterruptedException {
        BookingSearchResults bs = new BookingSearchResults(driver, wait);
        bs.clickFirstChoice();
    }

    @And("I save booking")
    public void iSaveBooking() {
        BookingSelectedHotel bsh = new BookingSelectedHotel(driver, wait);
        bsh.saveBooking("Izuzetan");
    }

    @And("I reserve the hotel")
    public void iReserveTheHotel() {
        BookingSelectedHotel bsh = new BookingSelectedHotel(driver, wait);
        bsh.reserve();
    }

    @And("I select the apartment")
    public void iSelectTheApartment() {
        BookingSelectedHotel bsh = new BookingSelectedHotel(driver, wait);
        bsh.selectFirstApartment("1");
    }

    @And("I click reserve")
    public void iClickReserve() throws InterruptedException {
        BookingSelectedHotel bsh = new BookingSelectedHotel(driver, wait);
        bsh.clickReserve();
    }

    @And("I fill the form about personal information")
    public void iFillTheFormAboutPersonalInformation() throws InterruptedException {
        BookingDetailsInfo bd = new BookingDetailsInfo(driver, wait);
        bd.fillForm("Vaši podaci", "Sara", "Mitrovic", "sara123@gmail.com", "sara123@gmail.com", "Petar Petrovic",
                "...add more information", "13");
    }

    //tear down
    @After
    public void quit() {
        //quitDriver();
    }



}
