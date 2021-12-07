package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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


    public void checkBooking(String expectedDest, String expectedDateFrom, String expectedDateTo, String numAdults, String numChildren, String numRooms, String ageValue) {

        Assert.assertEquals(destination.getAttribute("value"), expectedDest);

        assertEquals(dateFrom, expectedDateFrom);
        assertEquals(dateTo, expectedDateTo);

        click(arrowDown);

        assertEquals(numOfAdults, numAdults);
        assertEquals(numOfChildren, numChildren);
        assertEquals(numOfRooms, numRooms);
        Assert.assertEquals(age.getAttribute("value"), ageValue);

        click(okButton);


    }

}
