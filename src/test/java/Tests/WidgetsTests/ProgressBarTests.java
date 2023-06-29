package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.ProgressBarPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public ProgressBarPage progressBarPage;

    @BeforeMethod
    public void progressBarSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        progressBarPage = new ProgressBarPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Progress Bar"));
        sideBar.elementsSubMenuOption("Progress Bar").click();
    }

    @Test(priority = 10)
    public void verifyThatProgressBarLoadsCorrectly() {
        progressBarPage.clickOnStartStopButton();
        Assert.assertEquals(progressBarPage.startStopButton.getText(), "Stop");
        wait.until(ExpectedConditions.textToBePresentInElement(progressBarPage.progressBar, "100%"));
        Assert.assertEquals(progressBarPage.progressBar.getText(), "100%");
        Assert.assertEquals(progressBarPage.resetButton.getText(), "Reset");
    }

    @AfterMethod
    public void progressBarTearDown() {
        driver.manage().deleteAllCookies();
    }
}
