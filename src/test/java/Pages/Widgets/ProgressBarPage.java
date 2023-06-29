package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BaseTest {

    public ProgressBarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "progressBar")
    public WebElement progressBar;

    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(id = "resetButton")
    public WebElement resetButton;

    public void clickOnStartStopButton() {
        startStopButton.click();
    }
}
