package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.MenuPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public MenuPage menuPage;

    @BeforeMethod
    public void accordionSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        menuPage = new MenuPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Menu"));
        sideBar.elementsSubMenuOption("Menu").click();
    }

    @Test(priority = 10)
    public void verifyThatMenu2ItemHasSubMenus() throws InterruptedException {
        Thread.sleep(1000);
        menuPage.hoverOverMenu2();
        Assert.assertTrue(menuPage.subSubList.isEnabled());
        Assert.assertTrue(menuPage.subItem.isEnabled());
    }

    @Test(priority = 20)
    public void verifyThatSubSubMenuHasSubMenus() throws InterruptedException {
        Thread.sleep(1000);
        menuPage.hoverOverMenu2();
        waitForVisibility(menuPage.subSubList);
        menuPage.hoverOverSubSubList();
        Assert.assertTrue(menuPage.subSubItem1.isEnabled());
        Assert.assertTrue(menuPage.subSubItem2.isEnabled());
    }

    @AfterMethod
    public void menuTestsTearDown() {
        driver.manage().deleteAllCookies();
    }
}
