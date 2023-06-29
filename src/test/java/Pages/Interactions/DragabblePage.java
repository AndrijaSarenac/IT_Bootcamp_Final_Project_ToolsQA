package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragabblePage extends BaseTest {

    public DragabblePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dragBox")
    public WebElement dragBox;

    @FindBy(id = "draggableExample-tab-cursorStyle")
    public WebElement cursorTab;

    @FindBy(id = "draggableExample-tab-axisRestriction")
    public WebElement axisRestrictedTab;

    @FindBy(id = "restrictedX")
    public WebElement xAxis;

    @FindBy(id = "restrictedY")
    public WebElement yAxis;
}
