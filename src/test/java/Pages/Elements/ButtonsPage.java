package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage extends BaseTest {

    public WebElement clickMeOption;

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> clickMeButtons;

    public WebElement oneClickMeButton(String clickMeButtonName) {
        for (WebElement clickMe : clickMeButtons) {
            if (clickMe.getText().equals(clickMeButtonName)) {
                clickMeOption = clickMe;
                break;
            }
        }
        return clickMeOption;
    }

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;
}
