package Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBar extends BaseTest {

    public WebElement menuOption;
    public WebElement subMenuOption;

    public SideBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header-text")
    public List<WebElement> dropDownMenus;

    @FindBy(className = "text")
    public List<WebElement> subMenus;

    public WebElement dropDownMenuOption(String menuName) {
        for (WebElement menu : dropDownMenus) {
            if (menu.getText().equals(menuName)) {
                menuOption = menu;
                break;
            }
        }
        return menuOption;
    }

    public WebElement elementsSubMenuOption(String subMenuName) {
        for (WebElement submenu : subMenus) {
            if (submenu.getText().equals(subMenuName)) {
                subMenuOption = submenu;
                break;
            }
        }
        return subMenuOption;
    }
}
