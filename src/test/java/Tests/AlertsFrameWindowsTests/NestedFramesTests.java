package Tests.AlertsFrameWindowsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.AlertsFrameWindows.NestedFramesPage;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public NestedFramesPage nestedFramesPage;

    @BeforeMethod
    public void nestedFramesSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        nestedFramesPage = new NestedFramesPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Nested Frames"));
        sideBar.elementsSubMenuOption("Nested Frames").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanSwitchToParentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedFramesPage.parentFrame));
        Assert.assertEquals(nestedFramesPage.parentFrameName.getText(), "Parent frame");
    }

    @Test(priority = 20)
    public void verifyThatUserCanSwitchToChildFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedFramesPage.parentFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nestedFramesPage.childFrame));
        Assert.assertEquals(nestedFramesPage.childFrameName.getText(), "Child Iframe");
    }
}
