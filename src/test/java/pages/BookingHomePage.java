package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingHomePage extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BookingHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    //elements
    @FindBy(xpath = "//button[@data-modal-id='language-selection']")
    WebElement languageIcon;

    @FindBy(css = "#ss")
    WebElement destination;

    @FindBy(css = ".xp__dates.xp__group")
    WebElement dates;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    WebElement arrowNext;

    @FindBy(xpath = "//div[@class='xp__input-group xp__guests']")
    WebElement personInfo;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-adults']//button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    WebElement adults;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group-children ']//button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    WebElement children;

    @FindBy(xpath = "//select[contains(@aria-label, 'Uzrast deteta 1')]")
    WebElement ageOfChild;

    @FindBy(xpath = "//div[@class='sb-group__field sb-group__field-rooms']//button[@class='bui-button bui-button--secondary bui-stepper__add-button ']")
    WebElement rooms;

    @FindBy(css = ".sb-searchbox__button")
    WebElement buttonSearch;

    //stavljamo u String jer imamo dosta jezika i parametar ce biti zapravo jezik koji moze da se menja
    String languageLinkXpath = "//div[@class='bui-group bui-group--large']/div[2]//div[contains(text(),'$')]/../..";



    //methods
    public void chooseLanguage(String language) {
        click(languageIcon);
        click(driver.findElement(By.xpath(languageLinkXpath.replace("$", language))));
    }

    public void enterDestination(String destinationName) {
        enterText(destination, destinationName);
    }

    /**
     * Selects dateFrom and dateTo
     *
     * @param dateFrom format DD month YYYY
     * @param dateTo   format DD month YYYY
     */

    //comments
    public void selectDates(String dateFrom, String dateTo) {

        click(dates);

        //dateFrom
        while (true) {
            List<WebElement> startDateList = driver.findElements(By.xpath("//span[@aria-label='" + dateFrom + "']"));

            if (startDateList.size() == 0) {
                click(arrowNext);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + dateFrom + "']")));
                break;
            }
        }

        //dateTo
        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//span[@aria-label='" + dateTo + "']"));

            if (endDateList.size() == 0) {
                click(arrowNext);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + dateTo + "']")));
                break; //moram da ga prekinem kad nadjem datum jer ce zaglaviti sa kliktanjem
            }
        }
    }

//    String ageChild = "//select[contains(@aria-label, 'Uzrast deteta 1')]";
//
//    public void chooseAgeOfChildren(String age){
//
//    }

    //choose number of person, children and rooms
    public void addedPersonInfo(String adultsNum, String childrenNum, String ageValue, String roomsNum){

        click(personInfo);

        for(int i = 2; i < Integer.parseInt(adultsNum); i++){
            click(adults);
        }

        for(int i = 0; i < Integer.parseInt(childrenNum); i++){
            click(children);
        }
        selectByValue(ageOfChild, ageValue);

        for(int i = 1; i < Integer.parseInt(roomsNum); i++){
            click(rooms);
        }
    }

    public void clickSearch() throws InterruptedException {
        click(buttonSearch);
        Thread.sleep(3000);
    }
}