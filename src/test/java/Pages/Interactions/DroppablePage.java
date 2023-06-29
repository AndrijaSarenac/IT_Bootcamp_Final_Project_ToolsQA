package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DroppablePage extends BaseTest {

    public WebElement tabOption;

    public DroppablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "draggable")
    public WebElement dragElement;

    @FindBy(id = "droppable")
    public WebElement dropElement;

    @FindBy(id = "acceptable")
    public WebElement acceptableElement;

    @FindBy(id = "notAcceptable")
    public WebElement notAcceptableElement;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div/div[1]")
    public WebElement dragBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div/p")
    public WebElement notGreedyInnerBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/p")
    public WebElement outerBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div[2]")
    public WebElement dropField;

    @FindBy(css = ".nav-item.nav-link")
    public List<WebElement> tabOptions;

    public WebElement getOneTab(String tabName) {
        for (WebElement element : tabOptions) {
            if (element.getText().equals(tabName)) {
                tabOption = element;
                break;
            }
        }
        return tabOption;
    }
}
