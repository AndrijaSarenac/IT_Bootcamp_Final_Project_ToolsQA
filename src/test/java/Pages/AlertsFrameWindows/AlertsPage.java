package Pages.AlertsFrameWindows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseTest {

    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "promtButton")
    public WebElement promptButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmMessage;

    @FindBy(id = "promptResult")
    public WebElement promptMessage;

    public void clickOnAlertButton() {
        alertButton.click();
    }

    public void clickOnTimerAlertButton() {
        timerAlertButton.click();
    }

    public void clickOnConfirmButton() {
        confirmButton.click();
    }

    public void clickOnPromptButton() {
        promptButton.click();
    }
}
