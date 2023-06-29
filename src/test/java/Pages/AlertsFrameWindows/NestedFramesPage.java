package Pages.AlertsFrameWindows;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BaseTest {

    public NestedFramesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    public WebElement parentFrame;

    @FindBy(xpath = "/html/body/iframe")
    public WebElement childFrame;

    @FindBy(xpath = "/html/body")
    public WebElement parentFrameName;

    @FindBy(xpath = "/html/body")
    public WebElement childFrameName;
}
