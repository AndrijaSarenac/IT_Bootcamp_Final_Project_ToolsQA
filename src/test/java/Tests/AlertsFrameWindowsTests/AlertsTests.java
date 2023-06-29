package Tests.AlertsFrameWindowsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.AlertsFrameWindows.AlertsPage;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public AlertsPage alerts;

    @BeforeMethod
    public void alertsSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        alerts = new AlertsPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Alerts"));
        sideBar.elementsSubMenuOption("Alerts").click();
    }

    @Test(priority = 10)
    public void verifyThatAlertButtonOpensAlert() {
        alerts.clickOnAlertButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "You clicked a button");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 20)
    public void verifyThatTimerAlertButtonOpensAlert() {
        alerts.clickOnTimerAlertButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "This alert appeared after 5 seconds");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 30)
    public void verifyThatConfirmAlertButtonOpensAlert() {
        alerts.clickOnConfirmButton();
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Do you confirm action?");
        driver.switchTo().alert().accept();
    }

    @Test(priority = 40)
    public void verifyThatConfirmAlertShowsOkMessage() {
        alerts.clickOnConfirmButton();
        driver.switchTo().alert().accept();
        Assert.assertTrue(alerts.confirmMessage.isDisplayed());
        Assert.assertEquals(alerts.confirmMessage.getText(), "You selected Ok");
    }

    @Test(priority = 50)
    public void verifyThatConfirmAlertShowsCancelMessage() {
        alerts.clickOnConfirmButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(alerts.confirmMessage.isDisplayed());
        Assert.assertEquals(alerts.confirmMessage.getText(), "You selected Cancel");
    }

    @Test(priority = 60)
    public void verifyThatPromptAlertOpensPrompt() {
        alerts.clickOnPromptButton();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alertIsPresent());
        Assert.assertEquals(driver.switchTo().alert().getText(), "Please enter your name");
        driver.switchTo().alert().dismiss();
    }

    @Test(priority = 70)
    public void verifyThatCorrectNameIsDisplayed() {
        alerts.clickOnPromptButton();
        driver.switchTo().alert().sendKeys("Andrija");
        driver.switchTo().alert().accept();
        Assert.assertTrue(alerts.promptMessage.isDisplayed());
        Assert.assertEquals(alerts.promptMessage.getText(), "You entered Andrija");
    }

    @AfterMethod
    public void alertTearDown() throws InterruptedException {
        Thread.sleep(1000);
    }
}
