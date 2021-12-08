package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingSelectedHotel extends BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public BookingSelectedHotel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath= "//div[@id='js--hp-gallery-scorecard']//div[contains(text(), 'Izuzetan')]")
    WebElement comment;

    @FindBy(css = "#wl--wl_entrypoint_hp_head")
    WebElement btnSave;

    @FindBy(css = "#hp_book_now_button")
    WebElement btnBook;

    @FindBy(xpath = "//div[@class='hprt-block'][1]//select[@class='hprt-nos-select js-hprt-nos-select']")
    WebElement firstApartment;

    @FindBy(xpath = "//span[@class='bui-button__text js-reservation-button__text']")
    WebElement btnReserve;


    public void saveBooking(String expectedTxt){
        assertEquals(comment, expectedTxt);
        click(btnSave);
    }

    public void reserve(){
        click(btnBook);
    }

    public void selectFirstApartment(String valueOption){
        selectByValue(firstApartment, valueOption);
    }

    public void clickReserve() throws InterruptedException {
        click(btnReserve);
        Thread.sleep(5000);
    }

}
