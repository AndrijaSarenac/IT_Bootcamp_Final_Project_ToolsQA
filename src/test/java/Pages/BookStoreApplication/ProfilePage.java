package Pages.BookStoreApplication;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProfilePage extends BaseTest {

    public WebElement button;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName-value")
    public WebElement usernameConfirmation;

    @FindBy(className = "-next")
    public WebElement nexPage;

    @FindBy(id = "delete-record-undefined")
    public WebElement removeBookSymbol;

    @FindBy(id = "closeSmallModal-ok")
    public WebElement closeSmallModal;

    @FindBy(id = "submit")
    public List<WebElement> buttons;

    public WebElement getButton(String name) {
        for (WebElement element : buttons) {
            if (element.getText().equals(name)) {
                button = element;
                break;
            }
        }
        return button;
    }

    public void deleteOneBook() {
        removeBookSymbol.click();
        waitForClickability(closeSmallModal);
        closeSmallModal.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}