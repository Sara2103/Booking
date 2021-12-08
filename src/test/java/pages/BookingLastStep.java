package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingLastStep extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BookingLastStep(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".bui-nav-progress.bui-nav-progress--horizontal > li:nth-child(5) > strong")
    WebElement lastStep;

    @FindBy(xpath = "//span[@class='bui-date__title' and contains(text(), 'uto, 22. feb. 2022.')]") //ned, 2. jan. 2022.
    WebElement dateFrom;

    @FindBy(xpath = "//span[@class='bui-date__title' and contains(text(), 'čet, 3. mar. 2022.')]") //čet, 13. jan. 2022.
    WebElement dateTo;

    @FindBy(css = "#cc1")
    WebElement country;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(xpath = "//span[contains(text(),'Da, želim besplatnu e-potvrdu (preporučeno)')]")
    WebElement checkBoxEmail;

    @FindBy(css = "#__bui-2")
    WebElement cardNumber;

    @FindBy(css = ".sc-hBUSln.feoAcm")
    WebElement btnCardType;

    @FindBy(xpath = "//div[@class='Stack_item--grow__Wn4NR']/span[contains(text(), 'Visa')]")
    WebElement clickVisaCard;

    @FindBy(css = "#__bui-3")
    WebElement expiryDate;

    @FindBy(css = "#__bui-4")
    WebElement cvcNum;

    @FindBy(css = "button[name='book']")
    WebElement btnFinishReserve;

    @FindBy(xpath = "//div[@class='Stack_item--grow__Wn4NR Alert_content__3fAn4']/div/div/span")
    WebElement errorMessage;


    public void checkLast(String expectedInfo, String expectedDate1, String expectedDate2, String valueCountry, String txtPhone, String txtCardNum,
                          String txtExpiryDate, String txtCVC, String txtError) {
        assertEquals(lastStep, expectedInfo);
        assertEquals(dateFrom, expectedDate1);
        assertEquals(dateTo, expectedDate2);

        selectByValue(country, valueCountry);
        enterText(phone, txtPhone);
        click(checkBoxEmail);

        //relocate on iframe and take selector
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Payment']")));
        enterText(cardNumber, txtCardNum);
        click(btnCardType);
        click(clickVisaCard);
        enterText(expiryDate, txtExpiryDate);
        enterText(cvcNum, txtCVC);

        //back to parent frame because the button is inside
        driver.switchTo().parentFrame();
        click(btnFinishReserve);

        //again to switch to iframe to catch error message
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Payment']")));
        assertEquals(errorMessage, txtError);

        System.out.println("Test passed! :)");
    }
}
