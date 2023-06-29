package Tests.AlertsFrameWindowsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.AlertsFrameWindows.BrowserWindowsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class BrowserWindowsTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public BrowserWindowsPage browserWindowsPage;

    @BeforeMethod
    public void browserWindowsSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        browserWindowsPage = new BrowserWindowsPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        sideBar.elementsSubMenuOption("Browser Windows").click();
    }

    @Test(priority = 10)
    public void verifyThatNewTabButtonOpensNewTab() {
        browserWindowsPage.getWindowButton("New Tab").click();
        Assert.assertTrue(newTabIsPresent());
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 3, 0));
        driver.close();
        ArrayList<String> listOfWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfWindows.get(0));
    }

    @Test(priority = 20)
    public void verifyThatNewWindowButtonOpensNewWindow() {
        browserWindowsPage.getWindowButton("New Window").click();
        Assert.assertTrue(newWindowIsPresent());
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 3, 0));
    }

    @AfterMethod
    public void waitALittleBit() throws InterruptedException {
        //driver.close();
    }
}
