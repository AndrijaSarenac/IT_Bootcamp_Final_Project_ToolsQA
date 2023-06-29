package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResizablePage extends BaseTest {

    public ResizablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".react-resizable-handle.react-resizable-handle-se")
    public List<WebElement> handles;

    @FindBy(id = "resizableBoxWithRestriction")
    public WebElement firstBox;

    @FindBy(id = "resizable")
    public WebElement secondBox;

    public void resizeTheBox(int i, int x, int y) {
        actions.dragAndDropBy(handles.get(i), x, y).perform();
    }
}
