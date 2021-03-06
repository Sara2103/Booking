package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import tests.BaseTest;

import java.io.IOException;


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

        //DATE FORMAT: day of the week, DD. month YYYY. / Day of the week DD Month YYYY   |(practice short period) "nedelja, 2. januar 2022." "??etvrtak, 13. januar 2022." | (test) "utorak, 22. februar 2022.", "??etvrtak, 3. mart 2022."
        bs.checkBooking("Lisabon", "utorak, 22. februar 2022.", "??etvrtak, 3. mart 2022.",
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
    public void iFillTheFormAboutPersonalInformation() throws InterruptedException, IOException {
        BookingDetailsInfo bd = new BookingDetailsInfo(driver, wait);
        bd.fillForm("Va??i podaci", "Sara", "Mitrovic", "sara123@gmail.com", "sara123@gmail.com", "Petar Petrovic",
                "...add more information", "13");
    }

    //Date format: day of the week.(short), DD. month.(short) YYYY. | Day of the week(short) DD Month(short) YYYY (example: Mon 27 Dec 2021) | (practice: "ned, 2. jan. 2022.", "??et, 13. jan. 2022.") | (test: "uto, 22. feb. 2022.", "??et, 3. mar. 2022.")
    //Card format: 1111 1111 1111 1111
    //Expiry date: MMYY
    @And("I check the last step")
    public void iCheckTheLastStep() {
        BookingLastStep bl = new BookingLastStep(driver, wait);
        bl.checkLast("Poslednji korak", "uto, 22. feb. 2022.", "??et, 3. mar. 2022.", "bs", "146846565",
                "6435131311111111", "1226", "345",
                "??ao nam je, nismo mogli da obradimo va??u uplatu. Proverite podatke svoje kartice i poku??ajte ponovo.");
    }

    //tear down
    @After
    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        quitDriver();
    }
}
