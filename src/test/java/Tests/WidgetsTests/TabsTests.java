package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.TabsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabsTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public TabsPage tabsPage;

    @BeforeMethod
    public void tabsSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        tabsPage = new TabsPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Tabs"));
        sideBar.elementsSubMenuOption("Tabs").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanOpenOriginTab() {
        tabsPage.clickOnOriginTab();
        wait.until(ExpectedConditions.attributeToBe(tabsPage.whatTab, "aria-selected", "false"));
        Assert.assertEquals(tabsPage.whatTab.getAttribute("aria-selected"), "false");
        Assert.assertEquals(tabsPage.originTab.getAttribute("aria-selected"), "true");
    }

    @Test(priority = 20)
    public void verifyThatUserCanOpenUseTab() {
        tabsPage.clickOnUseTab();
        wait.until(ExpectedConditions.attributeToBe(tabsPage.whatTab, "aria-selected", "false"));
        Assert.assertEquals(tabsPage.whatTab.getAttribute("aria-selected"), "false");
        Assert.assertEquals(tabsPage.useTab.getAttribute("aria-selected"), "true");
    }
}
