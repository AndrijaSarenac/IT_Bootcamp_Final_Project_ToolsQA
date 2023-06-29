package Pages.AlertsFrameWindows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrowserWindowsPage extends BaseTest {

    public WebElement browserWindows;

    public BrowserWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> windowButtons;

    @FindBy(xpath = "/html/body/text()")
    public WebElement confirmationMessage;

    public WebElement getWindowButton(String name) {
        for (WebElement element : windowButtons) {
            if (element.getText().equals(name)) {
                browserWindows = element;
                break;
            }
        }
        return browserWindows;
    }
}
