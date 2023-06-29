package Pages.AlertsFrameWindows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BaseTest {

    public FramesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body")
    public WebElement frameMessage;

    @FindBy(id = "frame1")
    public WebElement frame1;

    @FindBy(id = "frame2")
    public WebElement frame2;
}
