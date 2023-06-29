package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipsPage extends BaseTest {

    public ToolTipsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "toolTipButton")
    public WebElement hoverButton;

    @FindBy(id = "toolTipTextField")
    public WebElement hoverField;

    @FindBy(linkText = "Contrary")
    public WebElement hoverWord;

    public void hoverOverButton() {
        actions.moveToElement(hoverButton).perform();
    }

    public void hoverOverField() {
        actions.moveToElement(hoverField).perform();
    }

    public void hoverOverWord() {
        actions.moveToElement(hoverWord).perform();
    }
}
