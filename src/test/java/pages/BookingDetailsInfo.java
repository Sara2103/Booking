package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BookingDetailsInfo extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BookingDetailsInfo(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".bui-nav-progress.bui-nav-progress--horizontal > li:nth-child(3) > strong")
    WebElement personalInfo;

    @FindBy(css = ".bui-form__group.bp-form-group.bp-form-group__bp_travel_purpose_business   ")
    WebElement btnYes;

    @FindBy(css = "#firstname")
    WebElement firstName;

    @FindBy(css = "#lastname")
    WebElement lastName;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(css = "#email_confirm")
    WebElement emailConfirm;

    @FindBy(css = ".bui-form__group.bp-form-group.bp-form-group__notstayer_false   ")
    WebElement mainGuest;

    @FindBy(xpath = "//tr[@class='guest-details']/td/input[1]")
    WebElement guestName;

//    @FindBy(css = ".bui-form__group.bp-form-group.bp-form-group__interested_car_rentals   ")
//    WebElement car;

    @FindBy(css = "#remarks")
    WebElement remarksInfo;

    @FindBy(css = "#checkin_eta_hour")
    WebElement time;

    @FindBy(css = "button[name='book']")
    WebElement book;


    //scrolls
    @FindBy(css = ".bp_legacy_form_box__title.bui-spacer--medium")
    WebElement scroll1;

    @FindBy(xpath = "//h2[contains(text(),'Recite nam koji su vaši posebni zahtevi.')]")
    WebElement scroll2;

    public void scrollFirst() {
        scrollToWebElement(scroll1);
    }

    public void scrollSecond() {
        scrollToWebElement(scroll2);
    }


    public void fillForm(String expectedInfo, String txtFirstName, String txtLastName, String txtEmail, String txtConfirm, String txtGuest, String txtRemarks, String timeValue)
            throws InterruptedException, IOException {
        assertEquals(personalInfo, expectedInfo);

        scrollFirst();

        click(btnYes);
        enterText(firstName, txtFirstName);
        enterText(lastName, txtLastName);
        enterText(email, txtEmail);
        enterText(emailConfirm, txtConfirm);
        click(mainGuest);

        Thread.sleep(3000);
        takeScreenshot("FillForm");

        enterText(guestName, txtGuest);

        //click(car); sometimes is not option

        scrollSecond();

        enterText(remarksInfo, txtRemarks);
        selectByValue(time, timeValue);

        click(book);
    }
}
