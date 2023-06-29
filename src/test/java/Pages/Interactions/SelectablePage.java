package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends BaseTest {

    public WebElement oneItem;
    public WebElement oneGridItem;

    public SelectablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mt-2.list-group-item.list-group-item-action")
    public List<WebElement> selectableItems;

    @FindBy(css = ".list-group-item.list-group-item-action")
    public List<WebElement> selectableGridItems;

    @FindBy(id = "demo-tab-grid")
    public WebElement gridTab;

    public WebElement getOneGridItem(String gridItemName) {
        for (WebElement element : selectableGridItems) {
            if (element.getText().equals(gridItemName)) {
                oneGridItem =  element;
                break;
            }
        }
        return oneGridItem;
    }

    public WebElement getOneSelectableItem(String itemName) {
        for (WebElement element : selectableItems) {
            if (element.getText().equals(itemName)) {
                oneItem = element;
            }
        }
        return oneItem;
    }

    public void selectOneItem(String name) {
        getOneSelectableItem(name).click();
    }

    public void selectOneGridItem(String name1) {
        getOneGridItem(name1).click();
    }

    public void clickOnGridTab() {
        gridTab.click();
    }
}
