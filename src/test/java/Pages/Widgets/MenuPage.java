package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BaseTest {

    public MenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Main Item 2")
    public WebElement menuItem2;

    @FindBy(linkText = "SUB SUB LIST »")
    public WebElement subSubList;

    @FindBy(linkText = "Sub Item")
    public WebElement subItem;

    @FindBy(linkText = "Sub Sub Item 1")
    public WebElement subSubItem1;

    @FindBy(linkText = "Sub Sub Item 2")
    public WebElement subSubItem2;

    public void hoverOverMenu2() {
        actions.moveToElement(menuItem2).perform();
    }

    public void hoverOverSubSubList() {
        actions.moveToElement(subSubList).perform();
    }
}
