package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public WebElement oneCheckBoxName;

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "result")
    public WebElement resultText;

    @FindBy(className = "rct-title")
    public List<WebElement> checkBoxNames;

    public WebElement getOneCheckBox(String checkBoxName) {
        for (WebElement element : checkBoxNames) {
            if (element.getText().equals(checkBoxName)) {
                oneCheckBoxName = element;
                break;
            }
        }
        return oneCheckBoxName;
    }

    @FindBy(className = "rct-checkbox")
    public List<WebElement> checkBoxes;

    public void checkAllBoxes() {
        for (WebElement element : checkBoxes) {
            element.click();
        }
    }
}
