package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class BookingSearchResults extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BookingSearchResults(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ss")
    WebElement destination;

    @FindBy(xpath = "//div[@class='sb-dates__col --checkin-field xp__date-time']//div[@class='sb-date-field__display']")
    WebElement dateFrom;

    @FindBy(xpath = "//div[@class='sb-dates__col --checkout-field xp__date-time']//div[@class='sb-date-field__display']")
    WebElement dateTo;

    @FindBy(css = ".xp__guests__toggle > svg")
    WebElement arrowDown;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-adults']//span[@class='bui-stepper__display']")
    WebElement numOfAdults;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group-children ']//span[@class='bui-stepper__display']")
    WebElement numOfChildren;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-rooms']//span[@class='bui-stepper__display']")
    WebElement numOfRooms;

    @FindBy(xpath = "//select[@aria-label='Uzrast deteta 1']")
    WebElement age;

    @FindBy(css = "#doneBtn")
    WebElement okButton;

    @FindBy(xpath = "//div[@class='_962ef834c _9fff1c544 b80262405b']//div[@data-filters-group='distance']/div/h3[contains(text(), 'Lisabon: udaljenost od centra')]")
    WebElement scToDistance;

    @FindBy(xpath = "//div[@class='_962ef834c _9fff1c544 b80262405b']//div[@data-filters-group='pri']/div/h3[contains(text(), 'Vaš budžet (po noćenju)')]/../../div[2]/div[3]")
    WebElement budget;

    @FindBy(xpath = "//div[@class='_962ef834c _9fff1c544 b80262405b']//div[@data-filters-group='distance']/div/h3[contains(text(), 'Lisabon: udaljenost od centra')]/../../div[3]/label")
    WebElement distance;

    @FindBy(xpath = "//div[@class='fd9ddecf26 _a18b9c14c c292f143b4']//ul/li[4]")
    WebElement bestChoice;

    @FindBy(xpath = "//div[@class='_fe1927d9e _0811a1b54 _a8a1be610 _022ee35ec b9c27d6646 fb3c4512b4 fc21746a73'][1]//span[contains(text(), 'Prikaži raspoloživost')]")
    WebElement btnSeeAvailability;



    public void checkBooking(String expectedDest, String expectedDateFrom, String expectedDateTo, String numAdults, String numChildren, String numRooms, String ageValue) throws InterruptedException {

        Assert.assertEquals(destination.getAttribute("value"), expectedDest);

        assertEquals(dateFrom, expectedDateFrom);
        assertEquals(dateTo, expectedDateTo);

        click(arrowDown);

        assertEquals(numOfAdults, numAdults);
        assertEquals(numOfChildren, numChildren);
        assertEquals(numOfRooms, numRooms);
        Assert.assertEquals(age.getAttribute("value"), ageValue);

        click(okButton);

        Thread.sleep(2000);
    }

    public void scroll(){
        scrollToWebElement(scToDistance);
    }

    //Filters
    public void checkBudget(){
        click(budget);
        scroll();
    }

    public void checkDistanceFromCentre(){
        click(distance);
    }

    public void selectBestReviewedLowestPrice(){
        click(bestChoice);
    }


    public void clickFirstChoice() throws InterruptedException {
        click(btnSeeAvailability); //open second tab, but driver is on the first

        Thread.sleep(6000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0)); //on the first tab

        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(1)); //on the second tab
    }
}
