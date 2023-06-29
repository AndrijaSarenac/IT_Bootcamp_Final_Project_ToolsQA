package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.ToolTipsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public ToolTipsPage toolTipsPage;

    @BeforeMethod
    public void toolTipsSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        toolTipsPage = new ToolTipsPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Tool Tips"));
        sideBar.elementsSubMenuOption("Tool Tips").click();
    }

    @Test(priority = 10)
    public void verifyThatMessageAppearsWhenHoveringOverButton() {
        toolTipsPage.hoverOverButton();
        wait.until(ExpectedConditions.attributeToBe(toolTipsPage.hoverButton, "aria-describedby", "buttonToolTip"));
        Assert.assertTrue(toolTipsPage.hoverButton.getAttribute("aria-describedby").contains("buttonToolTip"));
    }

    @Test(priority = 20)
    public void verifyThatMessageAppearsWhenHoveringOverField() {
        toolTipsPage.hoverOverField();
        wait.until(ExpectedConditions.attributeToBe(toolTipsPage.hoverField, "aria-describedby", "textFieldToolTip"));
        Assert.assertTrue(toolTipsPage.hoverField.getAttribute("aria-describedby").contains("textFieldToolTip"));
    }

    @Test(priority = 30)
    public void verifyThatMessageAppearsWhenHoveringOverWord() {
        toolTipsPage.hoverOverWord();
        wait.until(ExpectedConditions.attributeToBe(toolTipsPage.hoverWord, "aria-describedby", "contraryTexToolTip"));
        Assert.assertTrue(toolTipsPage.hoverWord.getAttribute("aria-describedby").contains("contraryTexToolTip"));
    }
}
