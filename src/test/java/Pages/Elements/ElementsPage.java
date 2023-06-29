package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTest {

    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Ad.Plus-728x90")
    public WebElement elementsPageMessage;
}
