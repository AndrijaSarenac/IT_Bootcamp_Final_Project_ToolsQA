package Tests.AlertsFrameWindowsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.AlertsFrameWindows.ModalDialogsPage;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogsTests extends BaseTest {

    public ModalDialogsPage modalDialogsPage;
    public HomePage homePage;
    public SideBar sideBar;

    @BeforeMethod
    public void modalDialogsSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        modalDialogsPage = new ModalDialogsPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Modal Dialogs"));
        sideBar.elementsSubMenuOption("Modal Dialogs").click();
    }

    @Test(priority = 10)
    public void verifyThatSmallModalWindowCanBeOpened() {
        modalDialogsPage.clickOnSmallModalButton();
        Assert.assertTrue(modalDialogsPage.smallModalWindow.isDisplayed());
        Assert.assertEquals(modalDialogsPage.smallModalName.getText(), "Small Modal");
        Assert.assertTrue(modalDialogsPage.closeSmallButton.isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatSmallModalWindowCanBeClosed() {
        modalDialogsPage.clickOnSmallModalButton();
        modalDialogsPage.clickOnCloseSmallButton();
        wait.until(ExpectedConditions.invisibilityOf(modalDialogsPage.smallModalWindow));
        Assert.assertFalse(elementIsPresent(modalDialogsPage.smallModalWindow));
    }

    @Test(priority = 30)
    public void verifyThatLargeModalWindowCanBeOpened() {
        modalDialogsPage.clickOnLargeModalButton();
        Assert.assertTrue(modalDialogsPage.largeModalWindow.isDisplayed());
        Assert.assertEquals(modalDialogsPage.largeModalName.getText(), "Large Modal");
        Assert.assertTrue(modalDialogsPage.closeLargeButton.isDisplayed());
    }

    @Test(priority = 40)
    public void verifyThatLargeModalWindowCanBeClosed() {
        modalDialogsPage.clickOnLargeModalButton();
        modalDialogsPage.clickOnCloseLargeButton();
        wait.until(ExpectedConditions.invisibilityOf(modalDialogsPage.largeModalWindow));
        Assert.assertFalse(elementIsPresent(modalDialogsPage.largeModalWindow));
    }

    @AfterMethod
    public void waitALittleBit() throws InterruptedException {
        Thread.sleep(1000);
    }
}
