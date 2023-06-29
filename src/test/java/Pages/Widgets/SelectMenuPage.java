package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectMenuPage extends BaseTest {

    public SelectMenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-1hwfws3")
    public List<WebElement> selectDropDowns;

}
