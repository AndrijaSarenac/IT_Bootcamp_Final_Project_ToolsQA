package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickerPage extends BaseTest {

    public DatePickerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateSelection;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement dateAndTimeSelection;

    public void clickOnDateSelection() {
        dateSelection.click();
    }

    public void clickOnDateAndTimeSelection() {
        dateAndTimeSelection.click();
    }
}
