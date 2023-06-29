package Pages.AlertsFrameWindows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends BaseTest {

    public ModalDialogsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;

    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallButton;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeButton;

    @FindBy(css = ".modal-dialog.modal-sm")
    public WebElement smallModalWindow;

    @FindBy(id = "example-modal-sizes-title-sm")
    public WebElement smallModalName;

    @FindBy(css = ".modal-dialog.modal-lg")
    public WebElement largeModalWindow;

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement largeModalName;

    public void clickOnSmallModalButton() {
        smallModalButton.click();
    }

    public void clickOnLargeModalButton() {
        largeModalButton.click();
    }

    public void clickOnCloseSmallButton() {
        closeSmallButton.click();
    }

    public void clickOnCloseLargeButton() {
        closeLargeButton.click();
    }
}
