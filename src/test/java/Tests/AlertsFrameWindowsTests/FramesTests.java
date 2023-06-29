package Tests.AlertsFrameWindowsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.AlertsFrameWindows.FramesPage;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public FramesPage framesPage;

    @BeforeMethod
    public void framesSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        framesPage = new FramesPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Frames"));
        sideBar.elementsSubMenuOption("Frames").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanSwitchToLargerChildFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framesPage.frame1));
        Assert.assertEquals(framesPage.frameMessage.getText(), "This is a sample page");
    }

    @Test(priority = 20)
    public void verifyThatUserCanSwitchToSmallerChildFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framesPage.frame2));
        Assert.assertEquals(framesPage.frameMessage.getText(), "This is a sample page");
    }
}
